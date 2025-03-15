package planta;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Classe Planta. Vamos irrigar!");

        ArrayList<Planta> plantas = new ArrayList<>();

        System.out.println("Vamos adicionar algumas plantas. (ex.: horta; fruteira; etc.");

        while(true)
        {
            System.out.println("Digite o nome da planta.");
            String nomePlanta = entrada.nextLine().trim();
            System.out.println("Digite o tipo da planta.");
            String tipoPlanta = entrada.nextLine().trim();
            System.out.println("Qual quantidade de água semanal essa planta precisa em litros? (ex.: 0,5)");
            double qtdAgua = entrada.nextDouble();
            entrada.nextLine();

            Planta novaPlanta = new Planta();
            novaPlanta.setNome(nomePlanta);
            novaPlanta.setTipo(tipoPlanta);
            novaPlanta.setNecessidadeDeAgua(qtdAgua);
            plantas.add(novaPlanta);

            System.out.println("Adicionar outro planta?.\n1 -> Sim\n2 -> Não");
            int sim = entrada.nextInt();
            entrada.nextLine();
            if (sim == 2)
                break;

        }
        System.out.println("Suas plantas são:");
        int i=1;
        for (Planta planta: plantas)
        {
            System.out.println(i + ") -> Nome: " + planta.getNome() + ", Tipo: " + planta.getTipo() + ", Necessidade de Água: " + planta.getNecessidadeDeAgua() + " litros/semana");
            i++;
        }

        System.out.println("Qual planta deseja irrigar? (digite o número de 1 a " + plantas.size() + ")");
        int escolha = entrada.nextInt();
        entrada.nextLine();
        Planta plantaEscolhida = plantas.get(escolha-1);

        System.out.println("Por quantas semanas deseja irrigar a " + plantaEscolhida.getNome() + "? (Informe um número inteiro)");
        int semanasDeIrrigacao = entrada.nextInt();
        entrada.nextLine();

        double litrosAgua = plantaEscolhida.calcularNecessidadeDeAgua(semanasDeIrrigacao);

        System.out.println("A " + plantaEscolhida.getNome() + " necessita de " + litrosAgua + " litros de água. Vamos irrigar?\n1 -> Sim\n2 -> Não");
        int irrigar = entrada.nextInt();
        entrada.nextLine();

        if (irrigar == 1)
        {
            plantaEscolhida.irrigar();
        }else
        {
            System.out.println("Que pena! A " +plantaEscolhida.getNome() + " sentirá sede.");
        }




    }
}
