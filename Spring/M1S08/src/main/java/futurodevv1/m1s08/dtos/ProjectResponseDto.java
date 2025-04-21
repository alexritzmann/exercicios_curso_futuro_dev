package futurodevv1.m1s08.dtos;

public record ProjectResponseDto(
        Long id,
        String name,
        String description,
        String region,
        Double co2Estimate,
        OrganizationResponseDto organization
) {
}
