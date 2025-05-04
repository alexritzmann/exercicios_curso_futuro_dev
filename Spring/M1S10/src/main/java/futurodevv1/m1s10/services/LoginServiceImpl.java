package futurodevv1.m1s10.services;

import futurodevv1.m1s10.dtos.LoginRequestDto;
import futurodevv1.m1s10.dtos.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService
{
    private final UserService userService;
    private final PasswordEncoder encoder;

    @Override
    public LoginResponseDto authenticate(LoginRequestDto dto)
    {
        UserDetails user = userService.loadUserByUsername(dto.getUsername());
        if (!encoder.matches(dto.getPassword(), user.getPassword()))
        {
            throw new UsernameNotFoundException(user.getUsername());
        }

        String token = dto.getUsername() + ":" + encoder.encode(dto.getPassword());
        token = Base64.getEncoder().encodeToString(token.getBytes());

        return LoginResponseDto.builder().type("Basic").token(token).build();
    }

}
