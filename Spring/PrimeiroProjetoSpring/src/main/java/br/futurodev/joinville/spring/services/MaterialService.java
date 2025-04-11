package br.futurodev.joinville.spring.services;

import br.futurodev.joinville.spring.dtos.MaterialRequestDto;
import br.futurodev.joinville.spring.dtos.MaterialResponseDto;
import br.futurodev.joinville.spring.models.Material;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialService
{

    public List<MaterialResponseDto> findAll()
    {
        List<MaterialResponseDto> response = new ArrayList<>();
        for (Material material : Material.getMaterials())
        {
            response.add(new MaterialResponseDto(material.getId(), material.getNome(), material.getDescricao()));
        }
        return response;

        // stream map faz o mesmo que o for a cima.
        // FAZ UM MAPEAMENTO DE Material para MaterialResponseDto
        //return Material.getMaterials().stream().map(material -> new MaterialResponseDto(material.getId(),material.getNome(), material.getDescricao())).collect(Collectors.toList());
    }

    public MaterialResponseDto save(MaterialRequestDto dto)
    {
        Material material = new Material();
        material.setNome(dto.nome());
        material.setDescricao(dto.descricao());

        material = Material.addMaterials(material);

        return new MaterialResponseDto(material.getId(), material.getNome(), material.getDescricao());
    }

    public MaterialResponseDto findById (Long id)
    {
        Material material = this.findMaterialById(id);
        if (material != null)
        {
            return new MaterialResponseDto(material.getId(), material.getNome(), material.getDescricao());
        }
        return null;
    }

    private Material findMaterialById (Long id)
    {
        for (Material material :Material.getMaterials())
        {
            if (material.getId().equals(id))
            {
                return material;
            }
        }
        return null;
    }

    public MaterialResponseDto update(Long id, MaterialRequestDto dto)
    {
        Material material = this.findMaterialById(id);
        if (material != null)
        {
            material.setNome(dto.nome());
            material.setDescricao(dto.descricao());
            return new MaterialResponseDto(material.getId(), material.getNome(), material.getDescricao());
        }
        return null;
    }

    public MaterialResponseDto deleteById(Long id)
    {
        boolean removed = Material.deleteMaterials(id);
        if(removed)
        {
            return new MaterialResponseDto(id,null,null);
        }
        return null;

    }



}
