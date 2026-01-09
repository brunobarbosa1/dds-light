package com.light.dds_light.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dds")
public class Dds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false, length = 155)
    private String tema;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false, length = 155)
    private String palestrante;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDateTime dataFim;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusDds status;


    public Dds() {}

    public Dds(String id, String tema, String descricao, String palestrante, LocalDateTime dataInicio, LocalDateTime dataFim, StatusDds status) {
        this.id = id;
        this.tema = tema;
        this.descricao = descricao;
        this.palestrante = palestrante;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public StatusDds getStatus() {
        return status;
    }

    public void setStatus(StatusDds status) {
        this.status = status;
    }
}