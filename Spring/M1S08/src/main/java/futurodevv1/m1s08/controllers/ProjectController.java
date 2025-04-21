package futurodevv1.m1s08.controllers;

import futurodevv1.m1s08.dtos.ProjectRequestDto;
import futurodevv1.m1s08.dtos.ProjectResponseDto;
import futurodevv1.m1s08.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
@RequiredArgsConstructor
public class ProjectController
{
    private final ProjectService service;

    // get "antigo". O get novo já trata esse caso também além de possibilitar uso de parametros.
    /*
    @GetMapping
    public List<ProjectResponseDto> get()
    {
        return service.findAll();
    }
    */

    @GetMapping
    public List<ProjectResponseDto> get(@RequestParam(required = false) String region, @RequestParam(required = false) String organizationName)
    {
        return service.findAll(region, organizationName);
    }

    @GetMapping("{id}")
    public ProjectResponseDto getById(@PathVariable Long id)
    {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseDto post(@RequestBody ProjectRequestDto dto)
    {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public ProjectResponseDto put(@RequestBody ProjectRequestDto dto, @PathVariable Long id)
    {
        return service.update(dto, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }

}
