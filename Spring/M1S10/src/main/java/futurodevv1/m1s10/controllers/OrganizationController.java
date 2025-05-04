package futurodevv1.m1s10.controllers;

import futurodevv1.m1s10.dtos.OrganizationRequestDto;
import futurodevv1.m1s10.dtos.OrganizationResponseDto;
import futurodevv1.m1s10.services.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("organizations")
@RequiredArgsConstructor
public class OrganizationController
{
    private final OrganizationService service;

    @GetMapping
    public List<OrganizationResponseDto> findAll()
    {
        return service.findAll();
    }

    @GetMapping("{id}")
    public OrganizationResponseDto findById(@PathVariable Long id)
    {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationResponseDto create(@RequestBody OrganizationRequestDto dto)
    {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public OrganizationResponseDto update(@RequestBody OrganizationRequestDto dto, @PathVariable Long id)
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
