package br.futurodev.joinville.spring.controllers;

import br.futurodev.joinville.spring.dtos.MaterialRequestDto;
import br.futurodev.joinville.spring.dtos.MaterialResponseDto;
import br.futurodev.joinville.spring.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materials")
public class MaterialController
{

    @Autowired
    private MaterialService service;

    @GetMapping
    public List<MaterialResponseDto> get() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MaterialResponseDto post(@RequestBody MaterialRequestDto dto) {
        return service.save(dto);
    }

    @GetMapping("{id}")
    public MaterialResponseDto getById(@PathVariable Long id)
    {
        return service.findById(id);
    }

    @PutMapping("{id}")
    public MaterialResponseDto put(@PathVariable Long id, @RequestBody MaterialRequestDto dto)
    {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)
    {
        service.deleteById(id);
    }





}
