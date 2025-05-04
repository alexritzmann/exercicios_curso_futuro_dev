package futurodevv1.m1s11.dtos;

import futurodevv1.m1s11.enums.UserRole;

public record UserRequestDto(
        String name,
        String username,
        String password,
        UserRole role
) {
}
