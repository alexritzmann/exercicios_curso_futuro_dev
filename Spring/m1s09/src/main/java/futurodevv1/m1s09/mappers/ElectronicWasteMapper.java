package futurodevv1.m1s09.mappers;

import futurodevv1.m1s09.dtos.ElectronicWasteRequestDto;
import futurodevv1.m1s09.dtos.ElectronicWasteResponseDto;
import futurodevv1.m1s09.entities.ElectronicWaste;

import java.util.List;

public class ElectronicWasteMapper
{
    private ElectronicWasteMapper() {}

    public static ElectronicWasteResponseDto toResponseDto(ElectronicWaste entity) {
        return new ElectronicWasteResponseDto(
                entity.getId(),
                entity.getType(),
                entity.getDescription()
        );
    }

    public static List<ElectronicWasteResponseDto> toResponseDtos(List<ElectronicWaste> entities)
    {
        return entities.stream().map(ElectronicWasteMapper::toResponseDto).toList();
    }

    public static ElectronicWaste toEntity(ElectronicWaste electronicWaste, ElectronicWasteRequestDto dto)
    {
        electronicWaste.setType(dto.type());
        electronicWaste.setDescription(dto.description());
        return electronicWaste;
    }
}
