package br.futurodev.joinville.coleta_seletiva_spring.dtos;

public record RotaResponseDto(
        Long idRota,
        String descricaoRota,
        String areaAbrangenciaRota,
        double eficienciaRota
) {}

