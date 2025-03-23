package mapeamentoareasverdesjoinville;

import Repositorios.AvaliacaoRepository;
import java.util.ArrayList;

public class AreaVerde
{
    private int idAreaVerde;
    private final String nomeAreaVerde;
    private final String tipoVegetacaoAreaVerde;
    private final boolean vinteEQuatroHoras;
    private final String horarioAberturaAreaVerde;
    private final String horarioFechamentoAreaVerde;
    private final ArrayList<String> atividadesAreaVerde;

    public int getIdAreaVerde() {return idAreaVerde;}
    public void setIdAreaVerde(int idAreaVerde) {this.idAreaVerde = idAreaVerde;}
    public String getNomeAreaVerde() {return nomeAreaVerde;}
    public String getTipoVegetacaoAreaVerde() {return tipoVegetacaoAreaVerde;}




    public AreaVerde(String nomeAreaVerde, String tipoVegetacaoAreaVerde, boolean vinteEQuatroHoras, String horarioAberturaAreaVerde, String horarioFechamentoAreaVerde, ArrayList<String> atividadesAreaVerde)
    {
        this.nomeAreaVerde = nomeAreaVerde;
        this.tipoVegetacaoAreaVerde = tipoVegetacaoAreaVerde;
        this.vinteEQuatroHoras = vinteEQuatroHoras;
        this.horarioAberturaAreaVerde = horarioAberturaAreaVerde;
        this.horarioFechamentoAreaVerde = horarioFechamentoAreaVerde;
        this.atividadesAreaVerde = atividadesAreaVerde;
    }

    public double calculaMediaAvaliacoes(AvaliacaoRepository avaliacaoRepository)
    {
        return avaliacaoRepository.calcularMediaGeral(this.idAreaVerde);
    }

    @Override
    public String toString()
    {
        return nomeAreaVerde;
    }

    public String toStringDetalhado()
    {
        String result = "ID da Área Verde: " + idAreaVerde + "\n" +
                        "Nome da Área Verde: " + nomeAreaVerde + "\n" +
                        "Tipo de Vegetação: " + tipoVegetacaoAreaVerde + "\n" +
                        "Aberto 24 horas: " + (vinteEQuatroHoras ? "Sim" : "Não") + "\n";

        if (!vinteEQuatroHoras) {
            result +=   "Horário de Abertura: " + horarioAberturaAreaVerde + "\n" +
                        "Horário de Fechamento: " + horarioFechamentoAreaVerde + "\n";
        }

        result +=       "Atividades Disponíveis: \n";
        for (String atividade : atividadesAreaVerde) {
            result +=   " - " + atividade;
        }

        return result;
    }


}
