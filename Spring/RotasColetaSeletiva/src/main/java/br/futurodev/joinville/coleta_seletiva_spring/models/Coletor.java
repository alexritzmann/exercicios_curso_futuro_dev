package br.futurodev.joinville.coleta_seletiva_spring.models;

public class Coletor
{
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

}
