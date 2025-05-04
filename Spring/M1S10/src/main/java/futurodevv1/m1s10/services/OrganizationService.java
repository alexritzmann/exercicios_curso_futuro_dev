package futurodevv1.m1s10.services;

import futurodevv1.m1s10.dtos.OrganizationRequestDto;
import futurodevv1.m1s10.dtos.OrganizationResponseDto;

import java.util.List;

public interface OrganizationService
{
    List<OrganizationResponseDto> findAll();
    OrganizationResponseDto findById(Long id);
    OrganizationResponseDto create(OrganizationRequestDto dto);
    OrganizationResponseDto update(OrganizationRequestDto dto, Long id);
    void delete(Long id);
}
