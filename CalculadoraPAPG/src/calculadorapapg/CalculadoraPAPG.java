package calculadorapapg;

import java.util.Scanner;

public class CalculadoraPAPG
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        int vlrInicial = 0;
        boolean vlrInicialValido = false;
        while (!vlrInicialValido)
        {
            System.out.println("Digite o valor incial da P.A ou P.G: \nObs: Somente valores inteiros.");
            if (entrada.hasNextInt())
            {
                vlrInicial = entrada.nextInt();
                vlrInicialValido = true;
            }else
            {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                entrada.next();
            }
        }

        int vlrRaiz = 0;
        boolean raizValida = false;
        while (!raizValida)
        {
            System.out.println("Excelente! Agora digite o valor da raiz da P.A ou P.G: \nLembre-se: Será aceito somente valors inteiros.");
            if (entrada.hasNextInt())
            {
                vlrRaiz = entrada.nextInt();
                raizValida = true;
            }else
            {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                entrada.next();
            }
        }

        int escolha = 0;
        while (escolha != 1 && escolha != 2)
        {
            System.out.println("Agora escolha o tipo de sequencia de 10 números você quer gerar.\nPara P.A. digite 1\nPara P.G. digite 2");
            if (entrada.hasNextInt())
            {
                escolha = entrada.nextInt();
                if (escolha != 1 && escolha != 2)
                {
                    System.out.println("Opção inválida! Digite 1 para P.A. ou 2 para P.G.");
                }
            }else
            {
                System.out.println("Opção inválida! Digite 1 para P.A. ou 2 para P.G.");
                entrada.next();
            }
        }

        double resultado;
        if (escolha == 1)
        {
            System.out.println("Os 10 primeiros valores da sua P.A. são:");
            int i = 1;
            System.out.println("Número " + i + ": " + vlrInicial);
            resultado = vlrInicial;
            i++;
            while (i<11)
            {
                resultado = resultado + vlrRaiz;
                System.out.println("Número " + i + ": " + resultado);
                i++;

            }
        }else
        {
            System.out.println("Os 10 primeiros valores da sua P.G. são:");
            int i = 1;
            System.out.println("Número " + i + ": " + vlrInicial);
            resultado = vlrInicial;
            i++;
            while (i<11)
            {
                resultado = resultado * vlrRaiz;
                System.out.println("Número " + i + ": " + resultado);
                i++;

            }
        }
    }
}