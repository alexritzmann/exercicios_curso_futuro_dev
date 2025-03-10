package emissaodecarbono;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        ArrayList<EmissaoDeCarbono> listaAtividades = new ArrayList<>();

        System.out.println("Emissao de carbono");

        System.out.println("Primeiramente, vamos cadastrar algumas atividades e a emissão de carbono emitida");

        boolean adicionarMais = true;
        while (adicionarMais)
        {
            System.out.println("Digite o nome da atividade:");
            String atividade = entrada.nextLine().trim();
            double quantidadeCO2;

            System.out.println("Digite a quantidade em kg de CO2 emitido por hora da atividade de "+ atividade + ":");
            while (true)
            {
                String strQuantidade = entrada.nextLine().replace(",", ".");
                try
                {
                    quantidadeCO2 = Double.parseDouble(strQuantidade);
                    break;
                }catch (NumberFormatException e)
                {
                    System.out.println("Entrada inválida. Digite a quantidade em kg (ex: 5,6):");
                }
            }
            EmissaoDeCarbono novaAtividade = new EmissaoDeCarbono(atividade, quantidadeCO2);
            listaAtividades.add(novaAtividade);
            int resposta;
            boolean validaEntrada = false;
            while (!validaEntrada)
            {
                System.out.println("Adicionar outra atividade?\n1 -> Sim\n2 -> Não");
                if (entrada.hasNextInt())
                {
                    resposta = entrada.nextInt();
                    entrada.nextLine();
                    if (resposta == 1)
                    {
                        validaEntrada = true;

                    }else if (resposta == 2)
                    {
                        adicionarMais = false;
                        validaEntrada = true;
                    }else
                    {
                        System.out.println("Número fora do intervalo! Digite um número inteiro de 1 ou 2");
                    }
                }else
                {
                    System.out.println("Entrada inválida! Digite um número inteiro de 1 ou 2");
                    entrada.next();
                }
            }


        }

        System.out.println("\nAgora, informe o tempo, em minutos, que vamos te mostrar a quantidade de kg de CO2 emitida para cada atividade cadastrada:");
        double minutos;
        while (true)
        {
            System.out.println("Digite o tempo em minutos:");
            String strMinutos = entrada.nextLine().replace(",", ".");
            try
            {
                minutos = Double.parseDouble(strMinutos);
                break;
            } catch (NumberFormatException e)
            {
                System.out.println("Entrada inválida. Digite um número válido (ex: 30,5):");
            }
        }

        System.out.println("\nAtividades cadastradas e emissão de CO2:");
        for (EmissaoDeCarbono atividade : listaAtividades)
        {
            atividade.calcularEmissaoCO2(minutos);
        }



    }
}
