package futurodevv1.m1s11.services;

import futurodevv1.m1s11.dtos.OrganizationRequestDto;
import futurodevv1.m1s11.dtos.OrganizationResponseDto;

import java.util.List;

public interface OrganizationService
{
    List<OrganizationResponseDto> findAll();
    OrganizationResponseDto findById(Long id);
    OrganizationResponseDto create(OrganizationRequestDto dto);
    OrganizationResponseDto update(OrganizationRequestDto dto, Long id);
    void delete(Long id);
}
