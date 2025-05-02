package futurodevv1.m1s09.controllers;

import futurodevv1.m1s09.dtos.CollectionPointRequestDto;
import futurodevv1.m1s09.dtos.CollectionPointResponseDto;
import futurodevv1.m1s09.services.CollectionPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("collection-points")
@RequiredArgsConstructor
public class CollectionPointController
{
    private final CollectionPointService service;

    @GetMapping
    public List<CollectionPointResponseDto> get()
    {
        return service.findAll();
    }

    @GetMapping("{id}")
    public CollectionPointResponseDto getById(@PathVariable Long id)
    {
        return service.findById(id);
    }

    @GetMapping("/electronic-waste/name/{name}")
    public ResponseEntity<List<CollectionPointResponseDto>> getByElectronicWasteName(@PathVariable String name)
    {
        return ResponseEntity.ok(service.findByElectronicWasteName(name));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CollectionPointResponseDto post(@RequestBody CollectionPointRequestDto dto)
    {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public CollectionPointResponseDto put(@RequestBody CollectionPointRequestDto dto, @PathVariable Long id)
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
