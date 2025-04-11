package br.futurodev.joinville.coleta_seletiva_spring.services;

import br.futurodev.joinville.coleta_seletiva_spring.dtos.ColetorRequestDto;
import br.futurodev.joinville.coleta_seletiva_spring.dtos.ColetorResponseDto;
import br.futurodev.joinville.coleta_seletiva_spring.models.Coletor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColetorService
{
    public ColetorResponseDto cadastraColetores(ColetorRequestDto dto)
    {
        Coletor coletor = new Coletor();
        coletor.setNomeColetor(dto.nomeColetor());
        coletor.setDescricaoColetor(dto.descricaoColetor());

        coletor = Coletor.addColetor(coletor);

        return new ColetorResponseDto(coletor.getIdColetor(), coletor.getNomeColetor(), coletor.getDescricaoColetor());
    }

    public List<ColetorResponseDto> consultaColetores()
    {
        List<ColetorResponseDto> response = new ArrayList<>();
        for (Coletor coletor : Coletor.getColetor())
        {
            response.add(new ColetorResponseDto(coletor.getIdColetor(), coletor.getNomeColetor(), coletor.getDescricaoColetor()));
        }
        return response;

    }

}
