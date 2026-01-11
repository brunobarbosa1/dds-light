package com.light.dds_light.mappers;

import com.light.dds_light.dto.request.DdsRequest;
import com.light.dds_light.dto.request.DdsUpdateRequest;
import com.light.dds_light.dto.response.DdsResponse;
import com.light.dds_light.entities.Dds;
import org.springframework.stereotype.Component;

@Component
public class DdsMapper {

    public static Dds toDds(DdsRequest request) {
        Dds dds = new Dds();
        dds.setTema(request.tema());
        dds.setDescricao(request.descricao());
        dds.setPalestrante(request.palestrante());
        dds.setDataInicio(request.dataInicio());
        dds.setDataFim(request.dataFim());
        return dds;
    }

    public static void merge(Dds dds, DdsUpdateRequest request) {
        if (request.tema() != null) {
            dds.setTema(request.tema());
        }
        if (request.descricao() != null) {
            dds.setDescricao(request.descricao());
        }
        if (request.palestrante() != null) {
            dds.setPalestrante(request.palestrante());
        }
        if (request.dataInicio() != null) {
            dds.setDataInicio(request.dataInicio());
        }
        if (request.dataFim() != null) {
            dds.setDataFim(request.dataFim());
        }
    }

    public static DdsResponse toDdsResponse(Dds dds) {
        return new DdsResponse(
                dds.getId(),
                dds.getTema(),
                dds.getDescricao(),
                dds.getPalestrante(),
                dds.getDataInicio(),
                dds.getDataFim(),
                dds.getStatus()
        );
    }

    public static Dds toDdsUpdate(DdsUpdateRequest request) {
        return new Dds(
                null,
                request.tema(),
                request.descricao(),
                request.palestrante(),
                request.dataInicio(),
                request.dataFim(),
                null
        );
    }
}
