package br.futurodev.joinville.coleta_seletiva_spring.services;

import br.futurodev.joinville.coleta_seletiva_spring.dtos.ContratoRequestDto;
import br.futurodev.joinville.coleta_seletiva_spring.dtos.ContratoResponseDto;
import br.futurodev.joinville.coleta_seletiva_spring.models.Coletor;
import br.futurodev.joinville.coleta_seletiva_spring.models.Contrato;
import br.futurodev.joinville.coleta_seletiva_spring.models.Rota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContratoService
{
    @Autowired
    private ColetorService coletorService;
    @Autowired
    private RotaService rotaService;

    public ContratoResponseDto cadastrarContrato(ContratoRequestDto dto)
    {
        Coletor coletor = coletorService.buscarColetorPorId(dto.coletorId());

        if (coletor == null)
        {
            throw new IllegalArgumentException("Coletor não encontrado com ID: " + dto.coletorId());
        }

        List<Long> rotasIds = dto.rotasIds();
        List<Rota> rotas = new ArrayList<>();

        for (Long id : rotasIds)
        {
            Rota rota = rotaService.buscarRotaPorId(id);
            if (rota == null)
            {
                throw new IllegalArgumentException("Rota não encontrada com ID: " + id);
            }
            rotas.add(rota);
        }

        Contrato contrato = new Contrato();
        contrato.setColetor(coletor);
        contrato.setRotas(rotas);

        Contrato.addContrato(contrato);

        return new ContratoResponseDto(contrato.getIdContrato(), contrato.getColetor(), contrato.getRotas());
    }

    public List<ContratoResponseDto> listarContratos()
    {
        List<Contrato> contratos = Contrato.getContratos();
        List<ContratoResponseDto> contratosDto = new ArrayList<>();

        for (Contrato contrato : contratos)
        {
            contratosDto.add(toDto(contrato));
        }

        return contratosDto;
    }

    private ContratoResponseDto toDto(Contrato contrato)
    {
        return new ContratoResponseDto(contrato.getIdContrato(), contrato.getColetor(), contrato.getRotas());
    }
}
