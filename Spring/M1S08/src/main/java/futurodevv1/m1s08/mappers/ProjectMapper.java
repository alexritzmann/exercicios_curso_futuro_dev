package futurodevv1.m1s08.mappers;

import futurodevv1.m1s08.dtos.OrganizationResponseDto;
import futurodevv1.m1s08.dtos.ProjectRequestDto;
import futurodevv1.m1s08.dtos.ProjectResponseDto;
import futurodevv1.m1s08.entities.Project;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectMapper
{

    private ProjectMapper() {}

    public static Project toEntity(Project project, ProjectRequestDto dto)
    {
        project.setName(dto.name());
        project.setDescription(dto.description());
        project.setRegion(dto.region());
        project.setCo2Estimate(dto.co2Estimate());
        return project;
    }

    public static ProjectResponseDto toResponseDto(Project entity)
    {
        if (entity == null)
        {
            return null;
        }

        OrganizationResponseDto orgDto = null;
        if (entity.getOrganization() != null)
        {
            orgDto = new OrganizationResponseDto(
                    entity.getOrganization().getId(),
                    entity.getOrganization().getName(),
                    entity.getOrganization().getContact()
            );
        }

        return new ProjectResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getRegion(),
                entity.getCo2Estimate(),
                orgDto
        );
    }

    public static List<ProjectResponseDto> toResponseDtos(List<Project> entities)
    {
        return entities.stream().map(ProjectMapper::toResponseDto).collect(Collectors.toList());
    }
}