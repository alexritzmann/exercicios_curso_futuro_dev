package futurodevv1.m1s11.mappers;

import futurodevv1.m1s11.dtos.UserResponseDto;
import futurodevv1.m1s11.dtos.UserRequestDto;
import futurodevv1.m1s11.entities.User;

import java.util.List;

public class UserMapper
{
    private UserMapper() {}

    public static UserResponseDto toDto(User user)
    {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

    public static List<UserResponseDto> toDtos(List<User> users)
    {
        return users.stream().map(UserMapper::toDto).toList();
    }

    public static User toEntity(User user, UserRequestDto dto)
    {
        user.setName(dto.name());
        user.setUsername(dto.username());
        user.setRole(dto.role());
        return user;
    }
}
