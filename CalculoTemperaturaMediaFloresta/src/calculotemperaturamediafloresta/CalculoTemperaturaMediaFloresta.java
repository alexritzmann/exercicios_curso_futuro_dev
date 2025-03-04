package calculotemperaturamediafloresta;

import java.util.Scanner;

public class CalculoTemperaturaMediaFloresta
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        Double[] temperaturaFloresta = new Double[7];

        System.out.println("Vamos registrar as últimas 7 temperaturas de uma floresta.");

        for (int i =0; i<temperaturaFloresta.length;i++)
        {
            System.out.println("Digite a 0" + (i+1) + "ª temperatura registrada: (Ex.: 28.5)");
            while (true)
            {
                String strTemperatura = entrada.nextLine().replace(",",".");
                try
                {
                    temperaturaFloresta[i] = Double.parseDouble(strTemperatura);
                    break;
                }catch (NumberFormatException e)
                {
                    System.out.println("Valor inválido. Digite uma temperatura");
                }
            }
        }

        double somaTemperatura = 0;
        for (Double temperatura : temperaturaFloresta) {
            somaTemperatura += temperatura;
        }

        System.out.println("A média de temperaturas registradas é de: " + somaTemperatura/temperaturaFloresta.length + "ºC");

    }
}
