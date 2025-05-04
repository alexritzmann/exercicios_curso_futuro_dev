package futurodevv1.m1s10.controllers;

import futurodevv1.m1s10.dtos.LoginRequestDto;
import futurodevv1.m1s10.dtos.LoginResponseDto;
import futurodevv1.m1s10.services.LoginService;
import jakarta.servlet.ServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController
{
    private final LoginService loginService;

    @PostMapping
    public LoginResponseDto login(@RequestBody LoginRequestDto dto, ServletRequest servletRequest)
    {
        return loginService.authenticate(dto);
    }
}