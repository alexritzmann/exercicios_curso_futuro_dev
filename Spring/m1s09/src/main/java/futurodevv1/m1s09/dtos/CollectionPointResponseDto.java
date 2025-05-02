package futurodevv1.m1s09.dtos;

import java.util.List;

public record CollectionPointResponseDto(
        Long id,
        String name,
        String address,
        String collectionDay,
        List<CollectionPointMaterialResponseDto> materialList
) {
}
