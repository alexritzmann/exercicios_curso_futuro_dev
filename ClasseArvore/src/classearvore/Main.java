package classearvore;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Vamos cadastrar uma arvore?\nPara isso precisamos que digite algumas informações:");

        System.out.println("Digite o nome da arvore:");
        String nome = entrada.nextLine().trim();

        int tipoNumerico = 0;
        boolean validaEntrada = false;
        while (!validaEntrada)
        {
            System.out.println("Digite o tipo da arvore\n1 -> Conífera\n2 -> Folhosa");
            if (entrada.hasNextInt())
            {
                tipoNumerico = entrada.nextInt();
                if (tipoNumerico >= 1 && tipoNumerico <= 2)
                {
                    validaEntrada = true;
                }else
                {
                    System.out.println("Número fora do intervalo! Digite um número inteiro de 1 ou 2");
                }
            }else
            {
                System.out.println("Entrada inválida! Digite um número inteiro de 1 ou 2");
                entrada.next();
            }
        }
        String tipo;
        if (tipoNumerico == 1)
        {
            tipo = "Conífera";
        }else
        {
            tipo = "Folhosa";
        }


        System.out.println("Digite a altura da arvore em metros: (Ex.: 10,95)");
        double altura;
        while (true)
        {
            String strAltura = entrada.nextLine().replace(",", ".");
            try
            {
                altura = Double.parseDouble(strAltura);
                break;
            }catch (NumberFormatException e)
            {
                System.out.println("Entrada inválida. Digite a altura em metros (ex: 10,95):");
            }
        }

        Arvore a1 = new Arvore(nome, tipo, altura);

        a1.exibirInformacoes();
        a1.calcularOxigenio();


    }
}
