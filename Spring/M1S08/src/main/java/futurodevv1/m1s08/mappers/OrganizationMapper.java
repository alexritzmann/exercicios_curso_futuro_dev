package futurodevv1.m1s08.mappers;

import futurodevv1.m1s08.dtos.OrganizationRequestDto;
import futurodevv1.m1s08.dtos.OrganizationResponseDto;
import futurodevv1.m1s08.entities.Organization;

import java.util.List;

public class OrganizationMapper
{

    private OrganizationMapper() {}

    public static Organization toEntity(Organization organization, OrganizationRequestDto dto) {
        organization.setName(dto.name());
        organization.setContact(dto.contact());
        return organization;
    }

    public static OrganizationResponseDto toResponseDto(Organization entity) {
        return new OrganizationResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getContact()
        );
    }

    public static List<OrganizationResponseDto> toResponseDtos(List<Organization> entities)
    {
        return entities.stream().map(OrganizationMapper::toResponseDto).toList();
    }
}