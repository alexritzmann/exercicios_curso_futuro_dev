package futurodevv1.m1s09.services;

import futurodevv1.m1s09.dtos.ElectronicWasteRequestDto;
import futurodevv1.m1s09.dtos.ElectronicWasteResponseDto;
import futurodevv1.m1s09.entities.ElectronicWaste;
import futurodevv1.m1s09.errors.exeptions.ElectronicWasteNotFoundException;
import futurodevv1.m1s09.mappers.ElectronicWasteMapper;
import futurodevv1.m1s09.repositories.ElectronicWasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectronicWasteServiceImpl implements ElectronicWasteService
{
    private final ElectronicWasteRepository repository;

    @Override
    public List<ElectronicWasteResponseDto> findAll()
    {
        List<ElectronicWaste> electronicWastes = repository.findAll();
        return ElectronicWasteMapper.toResponseDtos(electronicWastes);
    }

    @Override
    public ElectronicWasteResponseDto findById(Long id) {
        return repository.findById(id)
                .map(ElectronicWasteMapper::toResponseDto)
                .orElseThrow(() -> new ElectronicWasteNotFoundException(id));
    }


    @Override
    public ElectronicWasteResponseDto create(ElectronicWasteRequestDto dto)
    {
        ElectronicWaste electronicWaste = ElectronicWasteMapper.toEntity(new ElectronicWaste(), dto);
        return ElectronicWasteMapper.toResponseDto(repository.save(electronicWaste));
    }

    @Override
    public ElectronicWasteResponseDto update(ElectronicWasteRequestDto dto, Long id)
    {
        ElectronicWaste organization = findEntityById(id);
        ElectronicWasteMapper.toEntity(organization, dto);
        return ElectronicWasteMapper.toResponseDto(repository.save(organization));
    }

    @Override
    public void delete(Long id)
    {
        repository.deleteById(id);
    }

    private ElectronicWaste findEntityById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

}
