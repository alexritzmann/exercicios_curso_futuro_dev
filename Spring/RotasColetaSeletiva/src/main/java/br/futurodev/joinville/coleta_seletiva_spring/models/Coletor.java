package br.futurodev.joinville.coleta_seletiva_spring.models;

import java.util.ArrayList;
import java.util.List;

public class Coletor
{
    private static final List<Coletor> coletores = new ArrayList<>();
    private static Long sequenciaColetor = 1L;

    private Long idColetor;
    private String nomeColetor;
    private String descricaoColetor;

    public Long getIdColetor() {return idColetor;}
    public String getNomeColetor() {return nomeColetor;}
    public void setNomeColetor(String nomeColetor) {this.nomeColetor = nomeColetor;}
    public String getDescricaoColetor() {return descricaoColetor;}
    public void setDescricaoColetor(String descricaoColetor) {this.descricaoColetor = descricaoColetor;}

    public Coletor()
    {
        this.idColetor = sequenciaColetor++;
    }

    public static Coletor addColetor(Coletor coletor)
    {
        coletores.add(coletor);
        return coletor;
    }

    public static List<Coletor> getColetores() {
        return new ArrayList<>(coletores);
    }

}
