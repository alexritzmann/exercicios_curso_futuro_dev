package classefrequenciacardiaca;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);



        System.out.println("Hoje vamos calcular sua frequencia cardíaca. Para isso preciso de algumas informações. ok?");

        System.out.println("Primero, informe o ano de seu nascimento:");
        int ano = entrada.nextInt();

        System.out.println("Agora digite o mês de seu nascimento:");
        int mes = entrada.nextInt();

        System.out.println("E agora o dia do seu nascimento:");
        int dia = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Qual o seu primeiro nome?");
        String nome = entrada.nextLine();

        System.out.println("Qual o seu sobrenome?");
        String sobrenome = entrada.nextLine();

        FrequenciaCardiaca usuario = new FrequenciaCardiaca(nome, sobrenome, dia,mes,ano);

        System.out.println("Olá " + usuario.getNome() + " " + usuario.getSobrenome());
        System.out.println("Sua data de nascimento é " +usuario.getDiaNascimento()+"/"+usuario.getMesNascimento()+"/"+usuario.getAnoNascimento());
        System.out.println("Sua idade hoje é de " + usuario.calcularIdade(dia,mes,ano) + " anos");
        usuario.calculoFrequenciaCardiaca(usuario.getDiaNascimento(),usuario.getMesNascimento(),usuario.getAnoNascimento());




    }
}
