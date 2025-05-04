package futurodevv1.m1s10.dtos;

import futurodevv1.m1s10.enums.UserRole;
import lombok.Builder;

@Builder
public record UserResponseDto(
        Long id,
        String name,
        String username,
        UserRole role
) {
}
