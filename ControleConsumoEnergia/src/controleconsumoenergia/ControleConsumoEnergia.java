package controleconsumoenergia;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleConsumoEnergia
{
    public static void main(String[] args)
    {
        System.out.println("Controle de consumo de energia");
        Scanner entrada = new Scanner(System.in);
        ArrayList<Double> consumo = new ArrayList<>();

        boolean adicionarMaisConsumo =true;

        while (adicionarMaisConsumo)
        {
            while (true)
            {
                System.out.println("Deseja adicionar um consumo mensal?\n(1) para sim\n(2) para não");
                if (entrada.hasNextInt())
                {
                    int resposta = entrada.nextInt();
                    //entrada.nextLine();
                    if (resposta == 2)
                    {
                        adicionarMaisConsumo = false;
                        break;
                    }else if (resposta == 1)
                    {
                        System.out.println("Informe o consumo em kWh: (exemplo: 189.5");
                        entrada.nextLine();

                        while (true)
                        {
                            String validaConsumo = entrada.nextLine().replace(",",".");
                            try
                            {
                                double parseConsumo = Double.parseDouble(validaConsumo);
                                consumo.add(parseConsumo);
                                break;
                            }catch (NumberFormatException e)
                            {
                                System.out.println("Entada Inválida. Digite novamente");
                            }
                        }
                    }else
                    {
                        entrada.nextLine();
                    }
                }else
                {
                    System.out.println("Entrada inválida.\n");
                    entrada.nextLine();
                }

            }
        }



        System.out.println("Consumos cadastradas foram:");
        for (Double lista: consumo)
        {
            System.out.println(lista);
        }

        double consumoTotal =0;
        for (double mes: consumo)
        {
            consumoTotal = consumoTotal + mes;
        }

        System.out.printf("A média de consumo mensal é de: %.2f kWh\n", (consumoTotal/consumo.size()));

        if (consumoTotal/consumo.size()>200)
        {
            System.out.println("Seu consumo está acima de 200 kWh e acima do limite de sustentabilidade");
        }else
        {
            System.out.println("Seu consumo dentro do limite de sustentabilidade estabelecido.");
        }

    }
}
