package futurodevv1.m1s11.dtos;

import lombok.Builder;

@Builder
public record OrganizationResponseDto(
        Long id,
        String name,
        String contact
) {
}
