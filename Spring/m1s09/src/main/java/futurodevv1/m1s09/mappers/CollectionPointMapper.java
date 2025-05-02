package futurodevv1.m1s09.mappers;

import futurodevv1.m1s09.dtos.CollectionPointRequestDto;
import futurodevv1.m1s09.dtos.CollectionPointResponseDto;
import futurodevv1.m1s09.entities.CollectionPoint;

import java.util.List;

public class CollectionPointMapper
{
    private CollectionPointMapper() {}

    public static CollectionPointResponseDto toResponseDto(CollectionPoint entity)
    {
        return new CollectionPointResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getCollectionDay(),
                CollectionPointMaterialMapper.toResponseDtos(entity.getMaterialList())
        );
    }

    public static List<CollectionPointResponseDto> toResponseDtos(List<CollectionPoint> entities)
    {
        return entities.stream().map(CollectionPointMapper::toResponseDto).toList();
    }

    public static void toEntity(CollectionPoint collectionPoint, CollectionPointRequestDto dto)
    {
        collectionPoint.setName(dto.name());
        collectionPoint.setAddress(dto.address());
        collectionPoint.setCollectionDay(dto.collectionDay());
    }
}
