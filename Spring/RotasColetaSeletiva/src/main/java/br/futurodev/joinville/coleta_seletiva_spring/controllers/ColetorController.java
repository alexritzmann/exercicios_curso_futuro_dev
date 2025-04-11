package br.futurodev.joinville.coleta_seletiva_spring.controllers;

import br.futurodev.joinville.coleta_seletiva_spring.dtos.ColetorRequestDto;
import br.futurodev.joinville.coleta_seletiva_spring.dtos.ColetorResponseDto;
import br.futurodev.joinville.coleta_seletiva_spring.services.ColetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("coletores")
public class ColetorController
{
    @Autowired
    private ColetorService coletorService;

    @GetMapping
    public List<ColetorResponseDto> get()
    {
        return coletorService.consultaColetores();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ColetorResponseDto post(@RequestBody ColetorRequestDto dto)
    {
        return coletorService.cadastraColetores(dto);
    }
}
