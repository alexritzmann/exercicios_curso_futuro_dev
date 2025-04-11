package br.futurodev.joinville.coleta_seletiva_spring.dtos;

public record ColetorResponseDto(
        Long idColetor,
        String nomeColetor,
        String descricaoColetor
) {}
