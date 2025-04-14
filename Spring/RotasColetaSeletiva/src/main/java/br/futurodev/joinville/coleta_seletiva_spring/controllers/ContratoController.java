package br.futurodev.joinville.coleta_seletiva_spring.controllers;

import br.futurodev.joinville.coleta_seletiva_spring.dtos.ContratoRequestDto;
import br.futurodev.joinville.coleta_seletiva_spring.dtos.ContratoResponseDto;
import br.futurodev.joinville.coleta_seletiva_spring.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("contratos")
public class ContratoController
{
    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public List<ContratoResponseDto> listarContratos()
    {
        return contratoService.listarContratos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContratoResponseDto cadastrarContrato(@RequestBody ContratoRequestDto dto)
    {
        return contratoService.cadastrarContrato(dto);
    }
}
