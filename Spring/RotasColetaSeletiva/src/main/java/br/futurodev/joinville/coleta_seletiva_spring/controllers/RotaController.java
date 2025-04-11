package br.futurodev.joinville.coleta_seletiva_spring.controllers;

import br.futurodev.joinville.coleta_seletiva_spring.dtos.RotaRequestDto;
import br.futurodev.joinville.coleta_seletiva_spring.dtos.RotaResponseDto;
import br.futurodev.joinville.coleta_seletiva_spring.services.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rotas")
public class RotaController
{
    @Autowired
    private RotaService rotaService;

    @GetMapping
    public List<RotaResponseDto> listarRotas()
    {
        return rotaService.listarRotas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RotaResponseDto cadastrarRota(@RequestBody RotaRequestDto dto)
    {
        return rotaService.cadastrarRota(dto);
    }

    @GetMapping("/{id}")
    public RotaResponseDto buscarPorId(@PathVariable Long id)
    {
        return rotaService.buscarPorId(id);
    }
}
