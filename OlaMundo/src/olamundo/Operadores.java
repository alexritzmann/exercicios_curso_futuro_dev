package olamundo;


import java.util.Scanner;

public class Operadores {
    public static void main(String[] args) {
        boolean ehPar;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Qual seu ano de nascimento?");
        int anoNascimento = Integer.parseInt(entrada.nextLine());

        ehPar = anoNascimento % 2 == 0;

        System.out.println("Seu ano de nascimento é par? " + ehPar);

        int idade = 2025 - anoNascimento;

        System.out.println("Idade atual: " + idade);
        idade = idade +3;
        idade += 2;
        idade ++;

        System.out.println("idade depois de somar 3, 2 e autoincremento: " + idade);






    }
}
