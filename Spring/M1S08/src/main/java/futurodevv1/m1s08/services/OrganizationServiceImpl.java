package futurodevv1.m1s08.services;

import futurodevv1.m1s08.dtos.OrganizationRequestDto;
import futurodevv1.m1s08.dtos.OrganizationResponseDto;
import futurodevv1.m1s08.entities.Organization;
import futurodevv1.m1s08.mappers.OrganizationMapper;
import futurodevv1.m1s08.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService
{
    private final OrganizationRepository repository;

    /*
    @Override
    public List<OrganizationResponseDto> findAll()
    {
        List<Organization> organizations = repository.findAll();
        return OrganizationMapper.toResponseDtos(organizations);
    }
    */

    @Override
    public List<OrganizationResponseDto> findAll(String name, String contact)
    {
        String nameFilter = (name == null || name.trim().isEmpty()) ? null : name;
        String contactFilter = (contact == null || contact.trim().isEmpty()) ? null : contact;

        List<Organization> organizations = repository.findFiltered(nameFilter, contactFilter);
        return OrganizationMapper.toResponseDtos(organizations);
    }

    @Override
    public OrganizationResponseDto findById(Long id)
    {
        return repository.findById(id).map(OrganizationMapper::toResponseDto).orElse(null);
    }

    @Override
    public OrganizationResponseDto create(OrganizationRequestDto dto)
    {
        Organization organization = OrganizationMapper.toEntity(new Organization(), dto);
        return OrganizationMapper.toResponseDto(repository.save(organization));
    }

    @Override
    public OrganizationResponseDto update(OrganizationRequestDto dto, Long id)
    {
        Organization organization = findEntityById(id);
        OrganizationMapper.toEntity(organization, dto);
        return OrganizationMapper.toResponseDto(repository.save(organization));
    }

    @Override
    public void delete(Long id)
    {
        repository.deleteById(id);
    }


    private Organization findEntityById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

}
