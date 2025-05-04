package futurodevv1.m1s10.dtos;

import futurodevv1.m1s10.enums.UserRole;

public record UserRequestDto(
        String name,
        String username,
        String password,
        UserRole role
) {
}
