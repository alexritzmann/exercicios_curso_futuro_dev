package futurodevv1.m1s09.dtos;

public record CollectionPointMaterialResponseDto(
        Long id,
        ElectronicWasteResponseDto electronicWaste,
        Double capacityMax
) {
}
