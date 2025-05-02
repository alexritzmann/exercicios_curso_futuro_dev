package futurodevv1.m1s09.controllers;

import futurodevv1.m1s09.dtos.ElectronicWasteRequestDto;
import futurodevv1.m1s09.dtos.ElectronicWasteResponseDto;
import futurodevv1.m1s09.services.ElectronicWasteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("electronic-wastes")
@RequiredArgsConstructor
public class ElectronicWasteController
{
    private final ElectronicWasteService service;

    @GetMapping
    public List<ElectronicWasteResponseDto> get()
    {
        return service.findAll();
    }

    @GetMapping("{id}")
    public ElectronicWasteResponseDto getById(@PathVariable Long id)
    {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ElectronicWasteResponseDto post(@RequestBody ElectronicWasteRequestDto dto)
    {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public ElectronicWasteResponseDto put(@RequestBody ElectronicWasteRequestDto dto, @PathVariable Long id)
    {
        return service.update(dto, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id)
    {
        service.delete(id);
    }

}
