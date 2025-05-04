package futurodevv1.m1s11.dtos;

import futurodevv1.m1s11.enums.UserRole;
import lombok.Builder;

@Builder
public record UserResponseDto(
        Long id,
        String name,
        String username,
        UserRole role
) {
}
