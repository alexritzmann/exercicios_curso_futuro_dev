package futurodevv1.m1s08.dtos;

public record ProjectRequestDto(
        String name,
        String description,
        String region,
        Double co2Estimate,
        Long organizationId
) {
}
