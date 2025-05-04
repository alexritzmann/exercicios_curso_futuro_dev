package futurodevv1.m1s11.services;


import futurodevv1.m1s11.dtos.UserRequestDto;
import futurodevv1.m1s11.dtos.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService
{
    List<UserResponseDto> findAll();
    UserResponseDto findById(Long id);
    UserResponseDto create(UserRequestDto dto);
    UserResponseDto update(UserRequestDto dto, Long id);
    void delete(Long id);

}
