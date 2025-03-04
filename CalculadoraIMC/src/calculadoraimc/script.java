package calculadoraimc;

import java.util.Scanner;

public class script
{
    public static void main(String[] args)
    {
        System.out.println("Cálculo de IMC");

        Scanner entrada = new Scanner(System.in);
        double peso;
        double altura;

        System.out.println("Digite sua altura em metros (ex: 1,75): ");
        while (true)
        {
            String strAltura = entrada.nextLine().replace(",", ".");
            try
            {
                altura = Double.parseDouble(strAltura);
                break;
            }catch (NumberFormatException e)
            {
                System.out.println("Entrada inválida. Digite sua altura em metros (ex: 1,75):");
            }
        }


        System.out.println("Digite seu peso em kg (ex: 71,500): ");
        while (true)
        {
            String strPeso = entrada.nextLine().replace(",", ".");
            try
            {
                 peso = Double.parseDouble(strPeso);
                 break;
            }catch (NumberFormatException e)
            {
                System.out.println("Entrada inválida. Digite seu peso em kg (ex: 71,500):");
            }
        }

        double imc = peso / (altura * altura);

        System.out.printf("Seu IMC é: %.3f", imc);

    }
}
