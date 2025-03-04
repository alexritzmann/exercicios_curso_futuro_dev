package olamundo;

import java.util.Arrays;

public class ExemplosArrays
{
    public static void main(String[] args)
    {
        int[] anosDeCopa = {2022, 2018, 2014, 2010, 2006, 2002};

        //apenas atualizou a variável anosDeCopa

        String[] carros = new String[5];
        carros[0] = "Gol";
        carros[1] = "Argo";
        carros[2] = "Focus";
        carros[3] = "Kwid";
        carros[4] = "HB20";


        System.out.println(anosDeCopa[0]);

        System.out.println(carros[carros.length-1]);
        System.out.println(carros[4]);

        System.out.println(carros.length-1);

        System.out.println("gol".length());

        for (int i=0; i<carros.length; i++)
        {
            System.out.println("Indice: " + i + " - Carro: " +carros[i]);
        }

        int indice = 0;
        for (int ano: anosDeCopa)
        {
            System.out.println("Indice: " + indice + " - Ano da copa: " + ano);
            indice++; // gambi para recuperar index nesse for enchanced
        }

        Arrays.sort(anosDeCopa);
        // binarySearch só funciona se a array estiver ordenada. Por isso Arrays.sort antes.
        int index = Arrays.binarySearch(anosDeCopa, 2010);
        System.out.println("Posição " + index);

        double[] medias = new double[40];
        Arrays.fill(medias, 7.0); // completa todos os indices da array medias igual a 7
        System.out.println(medias[1]);


        int[][] matriz = new int[3][3];
        matriz [0][0] = 1;
        matriz [0][1] = 2;
        matriz [0][2] = 3;
        matriz [1][0] = 4;
        matriz [1][1] = 5;
        matriz [1][2] = 6;
        matriz [2][0] = 7;
        matriz [2][1] = 8;
        matriz [2][2] = 9;


        /*for (int linha =0; linha<matriz.length; linha++)
        {
            for (int coluna =0; coluna<matriz[linha].length; coluna++)
            {
                System.out.println(matriz[linha][coluna]);
            }
        }*/
        // código de cima escrito com for enhanced
        for (int[] linha : matriz) {
            for (int elemento : linha) {
                System.out.println(elemento);
            }
        }


    }
}
