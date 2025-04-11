package br.futurodev.joinville.coleta_seletiva_spring.models;

import java.util.ArrayList;
import java.util.List;

public class Contrato
{
    private static final List<Contrato> contratos = new ArrayList<>();
    private static Long sequenciaContrato = 1L;

    private Long idContrato;
    private Coletor coletor;
    private List<Rota> rotas = new ArrayList<>();

    public Long getIdContrato() { return idContrato; }
    public Coletor getColetor() { return coletor; }
    public void setColetor(Coletor coletor) { this.coletor = coletor; }
    public List<Rota> getRotas() { return rotas; }
    public void setRotas(List<Rota> rotas) { this.rotas = rotas; }

    public Contrato()
    {
        this.idContrato = sequenciaContrato++;
    }

    public static Contrato addContrato(Contrato contrato)
    {
        contratos.add(contrato);
        return contrato;
    }

    public static List<Contrato> getContratos()
    {
        return new ArrayList<>(contratos);
    }
}