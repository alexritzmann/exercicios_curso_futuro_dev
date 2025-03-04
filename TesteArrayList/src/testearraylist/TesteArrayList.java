package testearraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class TesteArrayList
{
    public static void main(String[] args)
    {
        System.out.println("Exercicio 2 da semana 3 - ARRAY LIST");

        Scanner entrada = new Scanner(System.in);

        ArrayList<String> lista1 = new ArrayList<>();
        ArrayList<String> lista2 = new ArrayList<>();

        System.out.println("Digite 5 palavras, uma de cada vez, que contenha pelo menos 1 caractere");
        for (int i=1; i<=5; i++)
        {
            switch (i)
            {
                case 1:
                    System.out.println("Digite a primeira palavra: ");
                    break;
                case 2:
                    System.out.println("Digite a segunda palavra: ");
                    break;
                case 3:
                    System.out.println("Digite a terceira palavra: ");
                    break;
                case 4:
                    System.out.println("Digite a quarta palavra: ");
                    break;
                case 5:
                    System.out.println("Digite a quinta palavra: ");
                    break;
            }

            String validaPalavra = entrada.nextLine();
            if (validaPalavra.contains(" "))
            {
                System.out.println("Palavra não pode ter espaços.");
                i--;

            }else if (validaPalavra.isEmpty())
            {
                System.out.println("Palavra deve conter pelo menos um caractere.");
                i--;
            }else
            {
                lista1.add(validaPalavra);
            }
        }

        for (String palavras: lista1)
        {
            if (palavras.length()<=3)
            {
                lista2.add(palavras);
            }
        }

        lista1.removeAll(lista2);

        System.out.println("-----");
        System.out.println("-----");

        System.out.println("Quantidade de palavras com mais de 3 caracteres (lista1): " +lista1.size());
        System.out.println("Palavras digitadas restantes na lista1:");
        if (lista1.isEmpty())
        {
            System.out.println("lista1 vazia");
        }else
        {
            for (String palavra : lista1)
            {
                System.out.println(palavra);
            }
        }

        System.out.println("Quantidade de palavras com 3 ou menos caracteres (lista2): " +lista2.size());
        System.out.println("Palavras transferidas para lista2:");
        if (lista2.isEmpty())
        {
            System.out.println("lista2 vazia");
        }else
        {
            for (String palavra : lista2)
            {
                System.out.println(palavra);
            }
        }
    }
}
