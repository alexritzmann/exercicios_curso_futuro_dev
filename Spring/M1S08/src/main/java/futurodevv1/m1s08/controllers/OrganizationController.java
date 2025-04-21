package futurodevv1.m1s08.controllers;

import futurodevv1.m1s08.dtos.OrganizationRequestDto;
import futurodevv1.m1s08.dtos.OrganizationResponseDto;
import futurodevv1.m1s08.services.OrganizationService;
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

    // get "antigo". O get novo já trata esse caso também além de possibilitar uso de parametros.
    /*
    @GetMapping
    public List<OrganizationResponseDto> get()
    {
        return service.findAll();
    }
    */

    @GetMapping
    public List<OrganizationResponseDto> get(@RequestParam(required = false) String name, @RequestParam(required = false) String contact)
    {
        return service.findAll(name, contact);
    }

    @GetMapping("{id}")
    public OrganizationResponseDto getById(@PathVariable Long id)
    {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationResponseDto post(@RequestBody OrganizationRequestDto dto)
    {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public OrganizationResponseDto put(@RequestBody OrganizationRequestDto dto, @PathVariable Long id)
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
