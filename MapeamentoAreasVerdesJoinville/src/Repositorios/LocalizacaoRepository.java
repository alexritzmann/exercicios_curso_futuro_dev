package Repositorios;

import mapeamentoareasverdesjoinville.Localizacao;

import java.util.ArrayList;

public class LocalizacaoRepository
{


    //LocalizacaoRepository, possuindo um atributo estático “List<Localizacao> LOCALIZACOES


    private static final ArrayList<Localizacao> LOCALIZACOES = new ArrayList<>();

    public void salvarLocalizacao(Localizacao novaLocalizacao)
    {
        novaLocalizacao.setIdLocalizacao(LOCALIZACOES.size()+1);
        LOCALIZACOES.add(novaLocalizacao);
    }

    public Localizacao localizarPorIdAreaVerde(int idAreaVerde)
    {
        for (Localizacao localizacao : LOCALIZACOES)
        {
            if (localizacao.getIdAreaVerde() == idAreaVerde)
            {
                return localizacao;
            }
        }
        return null;
    }


}
