package olamundo;

import java.util.Scanner;

public class CondicionaisERepeticoes
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Insira seu ano de nascimento: ");
        int anoNascimento = Integer.parseInt(entrada.nextLine());
        int idade = 2025 - anoNascimento;

        if(idade >= 18)
        {
            System.out.println("Você é maior de idade");
        }else
        {
            System.out.println("Você é menor de idade");
        }

        System.out.println("Você tem " + idade + " idade");

        if (idade<16)
        {
            System.out.println("Não é permitido votar.");
        }else if (idade < 18 || idade >= 70)
        {
            System.out.println("Pode votar, mas não é obrigatório.");
        }else
        {
            System.out.println("O voto é obrigatório.");
        }



    }
}
