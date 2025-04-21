package futurodevv1.m1s09.dtos;

import futurodevv1.m1s09.entities.CollectionPoint;
import futurodevv1.m1s09.entities.ElectronicWaste;

public record CollectionPointMaterialResponseDto(
        Long id,
        CollectionPoint collectionPoint,
        ElectronicWaste electronicWaste,
        Double capacityMax
) {
}
