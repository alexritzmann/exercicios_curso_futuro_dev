package monitoraqualidadear;

import java.util.Scanner;

public class MonitoraQualidadeAr
{
    public static void main(String[] args)
    {
        System.out.println("Monitoramento Qualidade do Ar");

        Scanner entrada = new Scanner(System.in);

        String[] cidades = new String[5];

        Integer[] indiceQualidadeAr = new Integer[5];

        System.out.println("Informe as 5 cidades que terão a qualidade do ar monitorado: ");

        for (int adicionacidade=0;adicionacidade<cidades.length;adicionacidade++)
        {
            while (true)
            {
                System.out.println("Cidade número 0" + (adicionacidade+1) + ":");
                String validaEntrada = entrada.nextLine().trim();

                if (!validaEntrada.isEmpty())
                {
                    cidades[adicionacidade] = validaEntrada;
                    break;
                }else
                {
                    System.out.println("O nome da cidade não pode ser vazio. Digite novamente.");
                }
            }
        }

        for (int i=0; i<indiceQualidadeAr.length;i++)
        {
            while (true)
            {
                System.out.println("Digite indice de qualidade do ar da cidade de " + cidades[i]);
                if (entrada.hasNextInt())
                {
                    int validaMaiorQueZero = entrada.nextInt();
                    entrada.nextLine();
                    if (validaMaiorQueZero>=0)
                    {
                        indiceQualidadeAr[i] = validaMaiorQueZero;
                        break;
                    }else
                    {
                        System.out.println("Entrada menor que zero.");
                    }
                }else
                {
                    System.out.println("Entrada inválida. Digite um número inteiro maior ou igual a zero");
                    entrada.nextLine();
                }
            }

        }

        int contador = 0;
        for (int i : indiceQualidadeAr) {
            if (i > 100) {
                contador = contador + 1;
            }
        }

        System.out.println("Existe(m) " + contador + " cidade(s) com indice de qualidade do ar acima de 100");

        for (int i = 0; i<indiceQualidadeAr.length;i++)
        {
            if (indiceQualidadeAr[i]>100)
            {
                System.out.println(cidades[i] + " com indice igual a: " + indiceQualidadeAr[i]);
            }
        }



    }
}
