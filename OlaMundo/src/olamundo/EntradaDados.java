package olamundo;

import java.util.Scanner;

public class EntradaDados
{
    public static void main(String[] args)
    {
        System.out.print("Digite seu nome: ");
        Scanner entrada = new Scanner(System.in);
        String nome = entrada.nextLine();

        System.out.print("Seu ano de nascimento: ");
        int anoNascimento = entrada.nextInt();
        entrada.nextLine();
        int idade = 2025 - anoNascimento;

        System.out.print("Mês de nascimento: ");
        int mesNascimento = Integer.parseInt(entrada.nextLine());

        System.out.print("Sua altura: ");
        double altura = Double.parseDouble(entrada.nextLine());
        System.out.print("Sua altura String: ");
        String strAltura = entrada.nextLine();
        if (strAltura.length() ==0)
        {
            System.out.println("Digitar um valor para a altura: ");
            strAltura = entrada.nextLine();
        }

        System.out.print("Digite outro nome: ");
        String outroNome = entrada.nextLine();
        Boolean ehIgual;
        if(nome.toUpperCase().equals(outroNome.toUpperCase()))
        {
            ehIgual = true;
        }else
        {
            ehIgual = false;
        }


        System.out.println("Seu nome é: "+ nome + " e sua idade é " + idade + " anos");
        System.out.println("Mês de nascimento: " + mesNascimento);
        System.out.println("Sua altura é: " + altura);
        System.out.println("Sua altura String é: " + strAltura);
        System.out.println("Nome UPPER_CASE: " + nome.toUpperCase());
        System.out.println("Nome LOWER_CASE: " + nome.toLowerCase());
        System.out.println("Nome é igual? " + ehIgual);
        System.out.println("Seu nome tem " + nome.length() + " caracteres (somando espaços em branco)");
        System.out.println(".trim serve para retirar espaços do inicio e do final  " + nome.trim());
        System.out.println("equalsIgnoreCaseserve para comprar as strings " + nome);

        System.out.println("Inicial do nome " + nome.charAt(0));

        System.out.println("ultima letra do nome " + nome.charAt(nome.length()-1));

        System.out.println("achar posição de index da primeira letra 'x' no nome " + nome.indexOf('x'));

        System.out.println("achar posição de index da última letra 'e' no nome " + nome.indexOf('e'));

        System.out.println("replace a letra e por i " + nome.replace('e','i'));

        String primeiroNome = nome;
        if (nome.indexOf(' ')>=0)
        {
            primeiroNome = nome.substring(0, nome.indexOf(' '));
        }
        System.out.println("Primeiro Nome: " + primeiroNome);

// verificar diferença entre isEmpty() e isBlank()
// string.isEmpty() - retorna true caso a string esteja vazia, ou seja, o “length” é zero. Se possuir espaços em branco, retorna false.
// string.isBlank() - retorna true se a string for vazia ou  possuir apenas espaços em branco.



    }
}
