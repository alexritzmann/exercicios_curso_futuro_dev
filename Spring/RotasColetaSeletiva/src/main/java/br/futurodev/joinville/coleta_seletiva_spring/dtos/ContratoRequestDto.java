package br.futurodev.joinville.coleta_seletiva_spring.dtos;

import java.util.List;

public record ContratoRequestDto(
        Long coletorId,
        List<Long> rotasIds
) {}

