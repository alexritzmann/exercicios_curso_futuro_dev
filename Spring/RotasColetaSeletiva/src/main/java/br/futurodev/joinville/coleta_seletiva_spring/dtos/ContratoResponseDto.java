package br.futurodev.joinville.coleta_seletiva_spring.dtos;

import br.futurodev.joinville.coleta_seletiva_spring.models.Coletor;
import br.futurodev.joinville.coleta_seletiva_spring.models.Rota;

import java.util.List;

public record ContratoResponseDto(
        Long idContrato,
        Coletor coletor,
        List<Rota> rotas
) {}
