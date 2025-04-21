package futurodevv1.m1s09.services;

import futurodevv1.m1s09.dtos.ElectronicWasteRequestDto;
import futurodevv1.m1s09.dtos.ElectronicWasteResponseDto;

import java.util.List;

public interface ElectronicWasteService
{

    List<ElectronicWasteResponseDto> findAll();
    ElectronicWasteResponseDto findById(Long id);
    ElectronicWasteResponseDto create(ElectronicWasteRequestDto dto);
    ElectronicWasteResponseDto update(ElectronicWasteRequestDto dto, Long id);
    void delete(Long id);
}
