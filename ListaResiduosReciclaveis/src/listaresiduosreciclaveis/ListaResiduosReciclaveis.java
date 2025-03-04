package listaresiduosreciclaveis;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaResiduosReciclaveis
{
    public static void main(String[] args)
    {
        System.out.println("Lista de resíduos recicláveis");
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> listaDeResiduos = new ArrayList<>();
        int limiteCategorias = 5;

        System.out.println("Você pode adicionar até 5 categorias. Vamos lá?");

        boolean adicionarMaisCategoria;
        while (listaDeResiduos.size() < limiteCategorias)
        {
            while (true)
            {
                System.out.println("Deseja adicionar uma categoria?\n(1) para sim\n(2) para não");
                if (entrada.hasNextInt())
                {
                    int resposta = entrada.nextInt();
                    entrada.nextLine();
                    if (resposta == 2)
                    {
                        adicionarMaisCategoria = false;
                        break;
                    }else if (resposta == 1)
                    {
                        adicionarMaisCategoria = true;
                        break;
                    }else
                    {
                        entrada.nextLine();
                    }
                }else
                {
                    System.out.println("Entrada inválida.\n");
                    entrada.nextLine();
                }

            }

            if(adicionarMaisCategoria)
            {
                while (true)
                {
                    System.out.println("Qual o nome da categoria?");
                    String validaCategoria = entrada.nextLine();
                    if (!validaCategoria.isEmpty())
                    {
                        listaDeResiduos.add(validaCategoria);
                        break;
                    }else
                    {
                        System.out.println("Favor inserir uma categoria. Não pode ser em branco.");
                    }
                }
            }else
            {
                break;
            }
        }

        //imprimir array list
        System.out.println("Categorias cadastradas foram:");
        for (String lista: listaDeResiduos)
        {
            System.out.println(lista);
        }

    }
}
