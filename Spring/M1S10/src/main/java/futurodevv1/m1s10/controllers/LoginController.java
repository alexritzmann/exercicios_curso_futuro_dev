package futurodevv1.m1s10.controllers;

import futurodevv1.m1s10.dtos.LoginRequestDto;
import futurodevv1.m1s10.dtos.LoginResponseDto;
import futurodevv1.m1s10.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController
{

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public LoginResponseDto login(@RequestBody LoginRequestDto dto)
    {
        UserDetails userDetails = userService.loadUserByUsername(dto.getUsername());

        if (!passwordEncoder.matches(dto.getPassword(), userDetails.getPassword()))
        {
            throw new BadCredentialsException("Senha ou usuário inválido");
        }

        var authentication = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());

        authenticationManager.authenticate(authentication);

        return LoginResponseDto.builder()
                .type("Basic")
                .token("Token")
                .build();
    }
}