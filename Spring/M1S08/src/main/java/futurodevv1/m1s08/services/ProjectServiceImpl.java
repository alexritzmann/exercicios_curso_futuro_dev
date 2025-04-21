package futurodevv1.m1s08.services;

import futurodevv1.m1s08.dtos.ProjectRequestDto;
import futurodevv1.m1s08.dtos.ProjectResponseDto;
import futurodevv1.m1s08.entities.Organization;
import futurodevv1.m1s08.entities.Project;
import futurodevv1.m1s08.mappers.ProjectMapper;
import futurodevv1.m1s08.repositories.OrganizationRepository;
import futurodevv1.m1s08.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService
{
    private final ProjectRepository repository;
    private final OrganizationRepository organizationRepository;

    /*
    @Override
    public List<ProjectResponseDto> findAll()
    {
        List<Project> projects = repository.findAll();
        return ProjectMapper.toResponseDtos(projects);
    }
    */

    @Override
    public List<ProjectResponseDto> findAll(String regionFilter, String organizationNameFilter)
    {
        String region = (regionFilter != null && !regionFilter.trim().isEmpty()) ? regionFilter : null;
        String orgName = (organizationNameFilter != null && !organizationNameFilter.trim().isEmpty()) ? organizationNameFilter : null;

        List<Project> projects = repository.findFiltered(region, orgName);
        return ProjectMapper.toResponseDtos(projects);
    }

    @Override
    public ProjectResponseDto findById(Long id)
    {
        return repository.findById(id).map(ProjectMapper::toResponseDto).orElse(null);
    }

    @Override
    public ProjectResponseDto create(ProjectRequestDto dto)
    {
        Project project = new Project();
        ProjectMapper.toEntity(project, dto);

        if (dto.organizationId() != null)
        {
            Organization organization = organizationRepository.findById(dto.organizationId()).orElse(null);
            project.setOrganization(organization);
        }

        return ProjectMapper.toResponseDto(repository.save(project));
    }

    @Override
    public ProjectResponseDto update(ProjectRequestDto dto, Long id)
    {
        Project project = findEntityById(id);
        ProjectMapper.toEntity(project, dto);
        return ProjectMapper.toResponseDto(repository.save(project));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Project findEntityById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    private String verifyFilter(String filter)
    {
        return (filter == null || filter.trim().isEmpty()) ? null : filter;
    }
}
