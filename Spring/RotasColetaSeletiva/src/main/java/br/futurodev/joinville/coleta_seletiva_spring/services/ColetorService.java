package br.futurodev.joinville.coleta_seletiva_spring.services;

import br.futurodev.joinville.coleta_seletiva_spring.dtos.ColetorRequestDto;
import br.futurodev.joinville.coleta_seletiva_spring.dtos.ColetorResponseDto;
import br.futurodev.joinville.coleta_seletiva_spring.models.Coletor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColetorService {

    public ColetorResponseDto cadastrarColetor(ColetorRequestDto dto)
    {
        Coletor coletor = new Coletor();
        coletor.setNomeColetor(dto.nomeColetor());
        coletor.setDescricaoColetor(dto.descricaoColetor());

        Coletor.addColetor(coletor);

        return toDto(coletor);
    }

    public List<ColetorResponseDto> listarColetores()
    {
        List<Coletor> coletores = Coletor.getColetores();
        List<ColetorResponseDto> dtos = new ArrayList<>();

        for (Coletor coletor : coletores)
        {
            dtos.add(new ColetorResponseDto(coletor.getIdColetor(), coletor.getNomeColetor(), coletor.getDescricaoColetor()));
        }
        return dtos;
    }

    public ColetorResponseDto buscarPorId(Long id)
    {
        for (Coletor coletor : Coletor.getColetores())
        {
            if (coletor.getIdColetor().equals(id))
            {
                return toDto(coletor);
            }
        }
        return null;
    }

    public Coletor buscarColetorPorId(Long id)
    {
        List<Coletor> coletores = Coletor.getColetores();
        for (Coletor coletor : coletores)
        {
            if (coletor.getIdColetor().equals(id))
            {
                return coletor;
            }
        }
        return null;
    }

    private Coletor findById(Long id)
    {
        for (Coletor coletor : Coletor.getColetores())
        {
            if (coletor.getIdColetor().equals(id))
            {
                return coletor;
            }
        }
        return null;
    }

    private ColetorResponseDto toDto(Coletor coletor)
    {
        return new ColetorResponseDto(coletor.getIdColetor(), coletor.getNomeColetor(), coletor.getDescricaoColetor());
    }
}

