package futurodevv1.m1s09.services;

import futurodevv1.m1s09.dtos.CollectionPointRequestDto;
import futurodevv1.m1s09.dtos.CollectionPointResponseDto;
import futurodevv1.m1s09.entities.CollectionPoint;
import futurodevv1.m1s09.entities.CollectionPointMaterial;
import futurodevv1.m1s09.entities.ElectronicWaste;
import futurodevv1.m1s09.errors.exeptions.CollectionPointNotFoundException;
import futurodevv1.m1s09.errors.exeptions.ElectronicWasteNotFoundException;
import futurodevv1.m1s09.mappers.CollectionPointMapper;
import futurodevv1.m1s09.repositories.CollectionPointMaterialRepository;
import futurodevv1.m1s09.repositories.CollectionPointRepository;
import futurodevv1.m1s09.repositories.ElectronicWasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectionPointServiceImpl implements CollectionPointService
{
    private final CollectionPointRepository repository;
    private final ElectronicWasteRepository electronicWasteRepository;
    private final CollectionPointMaterialRepository materialRepository;

    @Override
    public List<CollectionPointResponseDto> findAll()
    {
        List<CollectionPoint> collectionPoint = repository.findAll();
        return CollectionPointMapper.toResponseDtos(collectionPoint);
    }

    @Override
    public CollectionPointResponseDto findById(Long id) {
        return repository.findById(id)
                .map(CollectionPointMapper::toResponseDto)
                .orElseThrow(() -> new CollectionPointNotFoundException(id));
    }


    @Override
    @Transactional
    public CollectionPointResponseDto create(CollectionPointRequestDto dto)
    {
        CollectionPoint collectionPoint = new CollectionPoint();
        CollectionPointMapper.toEntity(collectionPoint, dto);
        CollectionPoint savedPoint = repository.save(collectionPoint);

        List<CollectionPointMaterial> materials = dto.materialList().stream().map(materialDto ->
            {
                ElectronicWaste waste = electronicWasteRepository.findById(materialDto.electronicWasteId())
                        .orElseThrow(() -> new RuntimeException("Electronic waste not found"));

                CollectionPointMaterial material = new CollectionPointMaterial();
                material.setCollectionPoint(savedPoint);
                material.setElectronicWaste(waste);
                material.setCapacityMax(materialDto.capacityMax());
                return material;
            }).toList();

        List<CollectionPointMaterial> savedMaterials = materialRepository.saveAll(materials);
        savedPoint.setMaterialList(savedMaterials);

        return CollectionPointMapper.toResponseDto(savedPoint);
    }

    @Override
    public CollectionPointResponseDto update(CollectionPointRequestDto dto, Long id)
    {
        CollectionPoint organization = findEntityById(id);
        CollectionPointMapper.toEntity(organization, dto);
        return CollectionPointMapper.toResponseDto(repository.save(organization));
    }

    @Override
    public void delete(Long id)
    {
        repository.deleteById(id);
    }

    public List<CollectionPointResponseDto> findByElectronicWasteName(String name)
    {
        List<CollectionPoint> points = repository.findByElectronicWasteNameContaining(name);
        if (points.isEmpty()) {
            throw new ElectronicWasteNotFoundException("Nenhum ponto encontrado para: " + name);
        }
        return CollectionPointMapper.toResponseDtos(points);
    }

    private CollectionPoint findEntityById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

}
