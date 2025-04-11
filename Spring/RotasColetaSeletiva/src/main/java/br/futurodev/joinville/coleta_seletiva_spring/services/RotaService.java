package br.futurodev.joinville.coleta_seletiva_spring.services;

import br.futurodev.joinville.coleta_seletiva_spring.dtos.RotaRequestDto;
import br.futurodev.joinville.coleta_seletiva_spring.dtos.RotaResponseDto;
import br.futurodev.joinville.coleta_seletiva_spring.models.Rota;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RotaService
{
    public RotaResponseDto cadastraRotas(RotaRequestDto dto)
    {
        Rota rota = new Rota();
        rota.setDescricaoRota(dto.descricaoRota());
        rota.setAreaAbrangenciaRota(dto.areaAbrangenciaRota());
        rota.setEnficienciaRota(dto.enficienciaRota());

        rota = Rota.addRotas(rota);

        return new RotaResponseDto(rota.getIdRota(), rota.getDescricaoRota(), rota.getAreaAbrangenciaRota(), rota.getEnficienciaRota());
    }

    public List<RotaResponseDto> consultaRotas()
    {
        List<RotaResponseDto> response = new ArrayList<>();
        for (Rota rota : Rota.getRotas())
        {
            response.add(new RotaResponseDto(rota.getIdRota(), rota.getDescricaoRota(), rota.getAreaAbrangenciaRota(), rota.getEnficienciaRota()));
        }
        return response;

    }

}
