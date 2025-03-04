package olamundo;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class ExemploArrayList
{
    public static void main(String[] args)
    {
        ArrayList<String> listaDeNomes = new ArrayList<>();

        listaDeNomes.add("Alex");
        listaDeNomes.add("Giovanna");
        listaDeNomes.add("Lua");
        listaDeNomes.add("Maia");
        listaDeNomes.add(2, "Pipoca");
        listaDeNomes.add("Doguinho");

        for (String nomes: listaDeNomes)
        {
            System.out.println(nomes);
        }
        System.out.println("-----");

        System.out.println("Quantidade de itens da lista: " + listaDeNomes.size());

        System.out.println("Nome no indice 1: " + listaDeNomes.get(1));

        listaDeNomes.add(1,"Doguinho");
        listaDeNomes.add(1,"Doguinho");
        listaDeNomes.add("TESTE REMOVER");

        System.out.println("-----");


        while(listaDeNomes.contains("Doguinho"))
        {
            listaDeNomes.remove("Doguinho");
        }

        listaDeNomes.add(2,"Doguinho");

        listaDeNomes.removeLast();

        for (String nomes: listaDeNomes)
        {
            System.out.println(nomes);
        }

        System.out.println("-----");


        System.out.println("Ordenar ArrayList");

        Collections.sort(listaDeNomes);

        for (String nomes: listaDeNomes)
        {
            System.out.println(nomes);
        }

        listaDeNomes.add("TESTE");
        listaDeNomes.add("TESTE");
        listaDeNomes.add("TESTE");
        System.out.println("-----");


        listaDeNomes.removeAll(List.of("TESTE"));

        for (String nomes: listaDeNomes)
        {
            System.out.println(nomes);
        }
        System.out.println("-----");

        System.out.println("Inverter a lista ( último será o primeiro.... etc)");

        Collections.reverse(listaDeNomes);

        for (String nomes: listaDeNomes)
        {
            System.out.println(nomes);
        }
        System.out.println("-----");

        System.out.println("Maior elemento: "+ Collections.max(listaDeNomes));
        System.out.println("Maior elemento: "+ Collections.min(listaDeNomes));



    }
}
