package futurodevv1.m1s10.services;

import futurodevv1.m1s10.dtos.UserRequestDto;
import futurodevv1.m1s10.dtos.UserResponseDto;

import java.util.List;

public interface OrganizationService
{
    List<UserResponseDto> findAll();
    UserResponseDto findById(Long id);
    UserResponseDto create(UserRequestDto dto);
    UserResponseDto update(UserRequestDto dto, Long id);
    void delete(Long id);
}
