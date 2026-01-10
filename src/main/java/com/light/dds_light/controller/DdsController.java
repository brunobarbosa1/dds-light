package com.light.dds_light.controller;

import com.light.dds_light.dto.request.DdsRequest;
import com.light.dds_light.dto.request.DdsUpdateRequest;
import com.light.dds_light.dto.response.DdsResponse;
import com.light.dds_light.service.DdsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dds")
@Validated
public class DdsController {

    private final DdsService ddsService;

    public DdsController(DdsService ddsService) {
        this.ddsService = ddsService;
    }

    @GetMapping
    public ResponseEntity<List<DdsResponse>> listarDds() {
        return ResponseEntity.ok(ddsService.listarDds());
    }

    @PostMapping
    public ResponseEntity<DdsResponse> criar(@RequestBody @Valid DdsRequest ddsRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ddsService.criar(ddsRequest));
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<DdsResponse> atualizar(@RequestBody @Valid DdsUpdateRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(ddsService.atualizar(id, request));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<DdsResponse> cancelar(@PathVariable Long id) {
        return ResponseEntity.ok().body(ddsService.cancelar(id));
    }

    @PutMapping("/{id}/concluir")
    public ResponseEntity<DdsResponse> concluir(@PathVariable Long id) {
        return ResponseEntity.ok().body(ddsService.concluir(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DdsResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(ddsService.buscarPorId(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ddsService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}