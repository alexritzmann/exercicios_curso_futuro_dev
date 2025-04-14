package br.futurodev.joinville.coleta_seletiva_spring.dtos;

public record RotaRequestDto(
        String descricaoRota,
        String areaAbrangenciaRota,
        double eficienciaRota
) {}

