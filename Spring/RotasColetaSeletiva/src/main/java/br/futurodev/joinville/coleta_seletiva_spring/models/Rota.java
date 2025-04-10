package br.futurodev.joinville.coleta_seletiva_spring.models;

public class Rota
{
    private static Long sequenciaRota = 1L;

    private Long idRota;
    private String descricaoRota;
    private String areaAbrangenciaRota;
    private double enficienciaRota;

    public Long getIdRota() {return idRota;}
    public String getDescricaoRota() {return descricaoRota;}
    public void setDescricaoRota(String descricaoRota) {this.descricaoRota = descricaoRota;}
    public String getAreaAbrangenciaRota() {return areaAbrangenciaRota;}
    public void setAreaAbrangenciaRota(String areaAbrangenciaRota) {this.areaAbrangenciaRota = areaAbrangenciaRota;}
    public double getEnficienciaRota() {return enficienciaRota;}
    public void setEnficienciaRota(double enficienciaRota) {this.enficienciaRota = enficienciaRota;}

    public Rota()
    {
        this.idRota = sequenciaRota++;
    }
}
