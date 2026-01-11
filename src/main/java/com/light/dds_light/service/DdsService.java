package com.light.dds_light.service;

import com.light.dds_light.dto.request.DdsRequest;
import com.light.dds_light.dto.request.DdsUpdateRequest;
import com.light.dds_light.dto.response.DdsResponse;
import com.light.dds_light.entities.Dds;
import com.light.dds_light.entities.StatusDds;
import com.light.dds_light.exceptions.DdsNotFoundException;
import com.light.dds_light.mappers.DdsMapper;
import com.light.dds_light.repository.DdsRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DdsService {

    private final DdsRepository repository;

    public DdsService(DdsRepository repository) {
        this.repository = repository;
    }


    public List<DdsResponse> listarDds() {
        return repository.findAll()
                .stream()
                .map(DdsMapper::toDdsResponse)
                .toList();
    }


    public DdsResponse criar(DdsRequest request) {
        validarIntervalo(request.dataInicio(), request.dataFim());
//        checarConflito(request.palestrante(), request.dataFim(), request.dataInicio(), null);
        Dds dds = DdsMapper.toDds(request);
        dds.setStatus(StatusDds.AGENDADO);
        return DdsMapper.toDdsResponse(repository.save(dds));
    }


    public DdsResponse atualizar(Long id, DdsUpdateRequest request) {
        Dds dds = repository.findById(id).orElseThrow(
                () -> new DdsNotFoundException("Dds não encontrado para ser atualizado"));
        DdsMapper.merge(dds, request);
//        checarConflito(request.palestrante(), request.dataFim(), request.dataInicio(), dds.getId());
        return DdsMapper.toDdsResponse(repository.save(dds));
    }


    public DdsResponse cancelar(Long id) {
        Dds dds = repository.findById(id).orElseThrow(
                () -> new DdsNotFoundException("Dds não encontrado para ser cancelado"));
        dds.setStatus(com.light.dds_light.entities.StatusDds.CANCELADO);
        return DdsMapper.toDdsResponse(repository.save(dds));
    }


    public DdsResponse concluir(Long id) {
        Dds dds = repository.findById(id).orElseThrow(
                () -> new DdsNotFoundException("Dds não encontrado para ser concluido"));
        dds.setStatus(com.light.dds_light.entities.StatusDds.CONCLUIDO);
        return DdsMapper.toDdsResponse(repository.save(dds));
    }


    public DdsResponse buscarPorId(Long id) {
        Dds dds = repository.findById(id).orElseThrow(
                () -> new DdsNotFoundException("Dds não encontrado"));
        return DdsMapper.toDdsResponse(dds);
    }


    public void deletar(Long id) {
        Dds dds = repository.findById(id).orElseThrow(
                () -> new DdsNotFoundException("Dds não encontrado para ser deletado"));
        repository.delete(dds);
    }


    private void validarIntervalo(LocalDateTime inicio, LocalDateTime fim) {
        if (inicio == null || fim == null) {
            throw new IllegalArgumentException("Data de início e data fim não podem ser nulas");
        }
        if (fim.isBefore(inicio)) {
            throw new IllegalArgumentException("Data de início não pode ser maior que a data fim");
        }
    }
}