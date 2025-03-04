package calculamediafinal;

import java.util.Scanner;

public class CalculaMediaFinal
{
    public static void main(String[] args)
    {
        System.out.println("Cálculo da Médica Final");

        Scanner entrada = new Scanner(System.in);
        double nota1 = -1;
        double nota2 = -1;
        double nota3 = -1;

        while (nota1 < 0 || nota1 > 10)
        {
            System.out.println("Digite a nota do semestre 1: (entre 0 e 10)");
            while (true)
            {
                String strNota1 = entrada.nextLine().replace(",", ".");
                try
                {
                    nota1 = Double.parseDouble(strNota1);
                    break;
                }catch (NumberFormatException e)
                {
                    System.out.println("Entra inválida. Digite a nota do semestre 1: (entre 0 e 10)");
                }
            }
            if(nota1 < 0 || nota1 >10)
            {
                System.out.println("Nota inválida! A nota deve estar entre 0 e 10. Tente novamente.");
            }
        }

        while (nota2 < 0 || nota2 > 10)
        {
            System.out.println("Digite a nota do semestre 2: (entre 0 e 10)");
            while (true)
            {
                String strNota2 = entrada.nextLine().replace(",", ".");
                try
                {
                    nota2 = Double.parseDouble(strNota2);
                    break;
                }catch (NumberFormatException e)
                {
                    System.out.println("Entrada inválida. Digite a nota do semestre 2: (entre 0 e 10)");
                }
            }
            if(nota2 < 0 || nota2 >10)
            {
                System.out.println("Nota inválida! A nota deve estar entre 0 e 10. Tente novamente.");
            }
        }

        while (nota3 < 0 || nota3 > 10)
        {
            System.out.println("Digite a nota do semestre 3: (entre 0 e 10)");
            while (true)
            {
                String strNota3 = entrada.nextLine().replace(",", ".");
                try
                {
                    nota3 = Double.parseDouble(strNota3);
                    break;
                } catch (NumberFormatException e)
                {
                    System.out.println("Entrada válida. Digite a nota do semestre 3: (entre 0 e 10)");
                }
            }
            if(nota3 < 0 || nota3 >10)
            {
                System.out.println("Nota inválida! A nota deve estar entre 0 e 10. Tente novamente.");
            }
        }

        double mediaFinal = (nota1+nota2+nota3)/3;
        System.out.printf("Sua média final é: %.2f", mediaFinal);

    }
}
