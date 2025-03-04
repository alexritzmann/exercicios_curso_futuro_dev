package roteirotrilhaecologica;

import java.util.ArrayList;
import java.util.Scanner;

public class RoteiroTrilhaEcologica
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> trilha = new ArrayList<>();

        System.out.println("Trilha Ecológica");
        trilha.add("Inicio");
        trilha.add("Fim");

        boolean adicionarParadaObservacao = true;

        System.out.println("Sua trilha está assim:");

        for (String roteiro : trilha)
        {
            System.out.println(roteiro);
        }

        while (adicionarParadaObservacao)
        {
            while (true)
            {
                System.out.println("Vamos adicionar mais pontos de observação para essa trilha?\n(1) para sim\n(2) para não");

                if (entrada.hasNextInt())
                {
                    int resposta = entrada.nextInt();
                    entrada.nextLine();

                    if (resposta == 2)
                    {
                        adicionarParadaObservacao = false;
                        break;
                    } else if (resposta == 1)
                    {
                        System.out.println("Sua trilha está assim:");

                        for (int i = 0; i < trilha.size(); i++)
                        {
                            int ponto = i + 1;
                            System.out.println("Ponto " + ponto + ": " + trilha.get(i));
                        }

                        while (true)
                        {
                            System.out.println("Depois de qual ponto você deseja adicionar um novo ponto?");
                            if (entrada.hasNextInt())
                            {
                                int pontoEscolhido = entrada.nextInt();
                                entrada.nextLine();

                                if (pontoEscolhido >= trilha.size() || pontoEscolhido < 1)
                                {
                                    System.out.println("Parada deve ser depois do Início e antes do Fim.");
                                }else
                                {
                                    System.out.println("Digite o nome do ponto:");
                                    String nomeDoPonto = entrada.nextLine();

                                    if (nomeDoPonto.trim().isEmpty())
                                    {
                                        System.out.println("Nome do ponto não pode ser vazio:");
                                    }else
                                    {
                                        trilha.add(pontoEscolhido, nomeDoPonto);
                                        break;
                                    }
                                }
                            }else
                            {
                                System.out.println("Entrada inválida. Digite um número.");
                                entrada.nextLine();
                            }
                        }

                        break;
                    }else
                    {
                        System.out.println("Entrada inválida. Digite 1 ou 2.\n");
                    }
                }else
                {
                    System.out.println("Entrada inválida. Digite um número.\n");
                    entrada.nextLine();
                }
            }
        }

        System.out.println("Sua trilha final ficou assim:");
        for (String roteiro : trilha)
        {
            System.out.println(roteiro);
        }

    }
}