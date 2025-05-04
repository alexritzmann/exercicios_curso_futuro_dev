package futurodevv1.m1s10.services;

import futurodevv1.m1s10.dtos.LoginRequestDto;
import futurodevv1.m1s10.dtos.LoginResponseDto;

public interface LoginService
{
    LoginResponseDto authenticate(LoginRequestDto dto);
}
