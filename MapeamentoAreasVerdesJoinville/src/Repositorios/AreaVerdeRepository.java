package Repositorios;

import models.AreaVerde;
import java.util.ArrayList;

public class AreaVerdeRepository
{
    private static final ArrayList<AreaVerde> AREAS_VERDES = new ArrayList<>();

    public void salvarAreaVerde (AreaVerde novaAreaVerde)
    {
        novaAreaVerde.setIdAreaVerde(AREAS_VERDES.size()+1);
        AREAS_VERDES.add(novaAreaVerde);
    }

    public void listarTodasAreasVerdes(AvaliacaoRepository avaliacaoRepository)
    {
        if(AREAS_VERDES.isEmpty())
        {
            System.out.println("Não há Áreas Verdes cadastradas.");
        }else
        {
            for (AreaVerde av : AREAS_VERDES)
            {
                double media = av.calculaMediaAvaliacoesDeUmaID(avaliacaoRepository);
                System.out.printf("ID: %d | Nome: %s | Tipo de Vegetação: %s | Média das avaliações: %.2f%n", av.getIdAreaVerde(), av.getNomeAreaVerde(), av.getTipoVegetacaoAreaVerde(), media);
            }
        }
    }

    public AreaVerde localizarAreaVerde(int id)
    {
        for (AreaVerde av : AREAS_VERDES)
        {
            if(id == av.getIdAreaVerde())
            {
                return av;
            }
        }
        return null;
    }

    public int quantidadeAreasVerdes()
    {
        return AREAS_VERDES.size();
    }
}
