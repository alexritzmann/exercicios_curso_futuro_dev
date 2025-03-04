package adivinheumnumero;

import java.util.Scanner;

public class AdivinheUmNumero
{
    public static void main(String[] args)
    {
        System.out.println("Adivinhe um número");
        Scanner entrada = new Scanner(System.in);

        int numeroUsuario =0;
        boolean vlrNumeroUsuariolValido = false;

        while (!vlrNumeroUsuariolValido)
        {
            System.out.println("Adivinhe qual número de 1 a 5 eu estou pensando: (apenas valores inteiros)");
            if (entrada.hasNextInt())
            {
                numeroUsuario = entrada.nextInt();
                if (numeroUsuario >= 1 && numeroUsuario <= 5)
                {
                    vlrNumeroUsuariolValido = true;
                }else
                {
                    System.out.println("Número fora do intervalo! Digite um número inteiro de 1 a 5");
                }
            }else
            {
                System.out.println("Entrada inválida! Digite um número inteiro de 1 a 5");
                entrada.next();
            }
        }

        int numeroAleatorio = (int) (Math.random() * 5) + 1;

        if(numeroUsuario == numeroAleatorio)
        {
            System.out.println("Você acertou!");
        }else
        {
            System.out.println("Você errou, o número correto era " + numeroAleatorio);
        }
    }
}
