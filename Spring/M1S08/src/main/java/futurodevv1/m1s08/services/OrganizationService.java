package futurodevv1.m1s08.services;

import futurodevv1.m1s08.dtos.OrganizationRequestDto;
import futurodevv1.m1s08.dtos.OrganizationResponseDto;

import java.util.List;

public interface OrganizationService
{
    //List<OrganizationResponseDto> findAll();
    List<OrganizationResponseDto> findAll(String nameFilter, String contactFilter);
    OrganizationResponseDto findById(Long id);
    OrganizationResponseDto create(OrganizationRequestDto dto);
    OrganizationResponseDto update(OrganizationRequestDto dto, Long id);
    void delete(Long id);

}
