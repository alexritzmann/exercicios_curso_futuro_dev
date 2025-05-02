package futurodevv1.m1s09.mappers;

import futurodevv1.m1s09.dtos.CollectionPointMaterialResponseDto;
import futurodevv1.m1s09.entities.CollectionPointMaterial;

import java.util.List;

public class CollectionPointMaterialMapper
{

    private CollectionPointMaterialMapper() {}

    public static CollectionPointMaterialResponseDto toResponseDto(CollectionPointMaterial entity)
    {
        return new CollectionPointMaterialResponseDto(
                entity.getId(),
                ElectronicWasteMapper.toResponseDto(entity.getElectronicWaste()),
                entity.getCapacityMax()
        );
    }

    public static List<CollectionPointMaterialResponseDto> toResponseDtos(List<CollectionPointMaterial> entities)
    {
        return entities.stream().map(CollectionPointMaterialMapper::toResponseDto).toList();
    }

}