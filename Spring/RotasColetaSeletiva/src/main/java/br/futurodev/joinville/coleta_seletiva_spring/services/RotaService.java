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
    public RotaResponseDto cadastrarRota(RotaRequestDto dto)
    {
        Rota rota = new Rota();
        rota.setDescricaoRota(dto.descricaoRota());
        rota.setAreaAbrangenciaRota(dto.areaAbrangenciaRota());
        rota.setEnficienciaRota(dto.eficienciaRota());

        Rota.addRotas(rota);

        return toDto(rota);
    }

    public List<RotaResponseDto> listarRotas()
    {
        List<Rota> rotas = Rota.getRotas();
        List<RotaResponseDto> responseDtos = new ArrayList<>();

        for (Rota rota : rotas)
        {
            responseDtos.add(toDto(rota));
        }
        return responseDtos;
    }

    public RotaResponseDto buscarPorId(Long id)
    {
        Rota rota = findById(id);
        return rota != null ? toDto(rota) : null;
    }

    private Rota findById(Long id)
    {
        for (Rota rota : Rota.getRotas())
        {
            if (rota.getIdRota().equals(id))
            {
                return rota;
            }
        }
        return null;
    }

    public Rota buscarRotaPorId(Long id)
    {
        for (Rota rota : Rota.getRotas())
        {
            if (rota.getIdRota().equals(id))
            {
                return rota;
            }
        }
        return null;
    }


    private RotaResponseDto toDto(Rota rota)
    {
        return new RotaResponseDto(rota.getIdRota(), rota.getDescricaoRota(), rota.getAreaAbrangenciaRota(), rota.getEnficienciaRota());
    }
}
