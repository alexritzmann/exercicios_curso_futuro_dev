package futurodevv1.m1s08.services;

import futurodevv1.m1s08.dtos.ProjectRequestDto;
import futurodevv1.m1s08.dtos.ProjectResponseDto;

import java.util.List;

public interface ProjectService
{
    //List<ProjectResponseDto> findAll();
    List<ProjectResponseDto> findAll(String regionFilter, String organizationNameFilter);
    ProjectResponseDto findById(Long id);
    ProjectResponseDto create(ProjectRequestDto dto);
    ProjectResponseDto update(ProjectRequestDto dto, Long id);
    void delete(Long id);

}
