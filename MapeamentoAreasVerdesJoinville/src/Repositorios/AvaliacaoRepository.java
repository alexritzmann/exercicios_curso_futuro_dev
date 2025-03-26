package Repositorios;

import models.Avaliacao;
import java.util.ArrayList;

public class AvaliacaoRepository
{
    private static final ArrayList<Avaliacao> AVALIACOES = new ArrayList<>();

    public void salvarAvaliacoes(Avaliacao novaAvaliacao)
    {
        novaAvaliacao.setIdAvaliacao(AVALIACOES.size()+1);
        AVALIACOES.add(novaAvaliacao);
    }

    public double calcularMediaGeral(int idAreaVerde)
    {
        double soma = 0;
        int contador = 0;

        for (Avaliacao avaliacao : AVALIACOES)
        {
            if (avaliacao.getIdAreaVerde() == idAreaVerde)
            {
                soma += avaliacao.calculaMediaAvaliacao();
                contador++;
            }
        }
        return contador > 0 ? soma / contador : 0;
    }

    public ArrayList<Avaliacao> obterAvaliacoesPorAreaVerde(int idAreaVerde)
    {
        ArrayList<Avaliacao> avaliacoesDaArea = new ArrayList<>();

        for (Avaliacao avaliacao : AVALIACOES) {
            if (avaliacao.getIdAreaVerde() == idAreaVerde) {
                avaliacoesDaArea.add(avaliacao);
            }
        }
        return avaliacoesDaArea;
    }
}
