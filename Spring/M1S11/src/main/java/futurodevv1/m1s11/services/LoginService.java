package futurodevv1.m1s11.services;

import futurodevv1.m1s11.dtos.LoginRequestDto;
import futurodevv1.m1s11.dtos.LoginResponseDto;

public interface LoginService
{
    LoginResponseDto authenticate(LoginRequestDto dto);
}
