package br.futurodev.joinville.spring.models;

import java.util.ArrayList;
import java.util.List;

public class Material
{
    private static final List<Material> materials = new ArrayList<>();
    private static Long sequencia = 1L;

    private Long id;
    private String nome;
    private String descricao;

    public Long getId() {return id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public Material()
    {
        this.id = sequencia++;
    }

    public static List<Material> getMaterials() {
        return materials;
    }

    public static Material addMaterials(Material material) {
        materials.add(material);
        return material;
    }

    public static boolean deleteMaterials(Long id) {
        return materials.removeIf(material -> material.getId().equals(id));
    }

}
