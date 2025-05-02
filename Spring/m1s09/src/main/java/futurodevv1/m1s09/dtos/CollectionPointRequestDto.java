package futurodevv1.m1s09.dtos;

import java.util.Collections;
import java.util.List;

public record CollectionPointRequestDto(
        String name,
        String address,
        String collectionDay,
        List<CollectionPointMaterialRequestDto> materialList
)
{
    public CollectionPointRequestDto {
        materialList = materialList != null ? materialList : Collections.emptyList();
    }
}
