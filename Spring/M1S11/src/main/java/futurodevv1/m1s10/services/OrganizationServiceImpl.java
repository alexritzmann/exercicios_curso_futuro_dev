package futurodevv1.m1s10.services;

import futurodevv1.m1s10.dtos.OrganizationRequestDto;
import futurodevv1.m1s10.dtos.OrganizationResponseDto;
import futurodevv1.m1s10.entities.Organization;
import futurodevv1.m1s10.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService
{
    private final OrganizationRepository repository;
    
    @Override
    public List<OrganizationResponseDto> findAll()
    {
        return repository.findAll().stream().map(
                org -> OrganizationResponseDto.builder()
                        .id(org.getId())
                        .name(org.getName())
                        .contact(org.getContact())
                        .build()
        ).toList();
    }

    @Override
    public OrganizationResponseDto findById(Long id)
    {
        Organization org = repository.findById(id).orElseThrow();

        return OrganizationResponseDto.builder()
                .id(org.getId())
                .name(org.getName())
                .contact(org.getContact())
                .build();
    }

    @Override
    public OrganizationResponseDto create(OrganizationRequestDto dto)
    {
        Organization org = new Organization();
        org.setName(dto.name());
        org.setContact(dto.contact());

        org = repository.save(org);

        return findById(org.getId());
    }

    @Override
    public OrganizationResponseDto update(OrganizationRequestDto dto, Long id)
    {
        Organization org = repository.findById(id).orElseThrow();
        org.setName(dto.name());
        org.setContact(dto.contact());

        org = repository.save(org);

        return findById(org.getId());
    }

    @Override
    public void delete(Long id)
    {
        findById(id);
        repository.deleteById(id);
    }

}
