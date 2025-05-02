package futurodevv1.m1s09.services;

import futurodevv1.m1s09.dtos.CollectionPointResponseDto;
import futurodevv1.m1s09.dtos.CollectionPointRequestDto;

import java.util.List;

public interface CollectionPointService
{
    List<CollectionPointResponseDto> findAll();
    CollectionPointResponseDto findById(Long id);
    CollectionPointResponseDto create(CollectionPointRequestDto dto);
    CollectionPointResponseDto update(CollectionPointRequestDto dto, Long id);
    void delete(Long id);

    List<CollectionPointResponseDto> findByElectronicWasteName(String name);

}
