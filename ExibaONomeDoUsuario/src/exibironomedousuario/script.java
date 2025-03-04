package exibironomedousuario;

import java.util.Scanner;

public class script
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);


        System.out.println("Qual o seu sobrenome?");
        String sobrenome = entrada.nextLine().trim();

        System.out.println("Qual o seu nome?");
        String nome = entrada.nextLine().trim();

        System.out.println("Seu nome completo é " +nome +" "+sobrenome);
        System.out.println("Seu nome tem " +(sobrenome.length()+nome.length()) + " letras");

    }
}
