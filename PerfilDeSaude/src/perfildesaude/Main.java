package perfildesaude;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Hoje vamos calcular fazer seu perfil de saúde. Para isso preciso de algumas informações. ok?");

        System.out.println("Qual o seu primeiro nome?");
        String nome = entrada.nextLine();

        System.out.println("Qual o seu sobrenome?");
        String sobrenome = entrada.nextLine();

        System.out.println("Qual o seu sexo?\n1 -> Masculino\n2 -> Feminino");
        String sexo = entrada.nextLine();

        System.out.println("Primero, informe o ano de seu nascimento:");
        int ano = entrada.nextInt();

        System.out.println("Agora digite o mês de seu nascimento:");
        int mes = entrada.nextInt();

        System.out.println("E agora o dia do seu nascimento:");
        int dia = entrada.nextInt();

        System.out.println("Para calcular seu IMC, preciso que informe sua altura em metros: Ex. 1,75");
        double altura = entrada.nextDouble();

        System.out.println("Agora informe seu peso em kg. Ex.: 75,600");
        double peso = entrada.nextDouble();
        entrada.nextLine();

        boolean sex = true;
        if (sexo == "1")
        {
            sex = true;
        }else
        {
            sex = false;
        }

        PerfilDeSaude usuario = new PerfilDeSaude(nome, sobrenome, sex, ano, mes, dia, altura, peso);

        System.out.println("Olá " + usuario.getNome() + " " + usuario.getSobrenome());
        System.out.println("Sua data de nascimento é " +usuario.getDiaNascimento()+"/"+usuario.getMesNascimento()+"/"+usuario.getAnoNascimento());
        System.out.println("Você é do sexo " +usuario.verficaSexo(sex));
        System.out.println("Sua idade hoje é de " + usuario.calcularIdade(dia,mes,ano) + " anos");
        usuario.calcularFrequenciaCardiaca(usuario.getDiaNascimento(),usuario.getMesNascimento(),usuario.getAnoNascimento());
        System.out.printf("Seu IMC atual é de %.2f%n", usuario.calcularIMC(usuario.getPeso(), usuario.getAltura()));









    }
}
