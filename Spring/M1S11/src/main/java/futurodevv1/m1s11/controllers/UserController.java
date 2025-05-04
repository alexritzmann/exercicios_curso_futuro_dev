package futurodevv1.m1s11.controllers;

import futurodevv1.m1s11.dtos.UserRequestDto;
import futurodevv1.m1s11.dtos.UserResponseDto;
import futurodevv1.m1s11.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController
{
    private final UserService service;

    @GetMapping
    public List<UserResponseDto> findAll()
    {
        return service.findAll();
    }

    @GetMapping("{id}")
    public UserResponseDto findById(@PathVariable Long id)
    {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@RequestBody UserRequestDto dto)
    {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public UserResponseDto update(@RequestBody UserRequestDto dto, @PathVariable Long id)
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
