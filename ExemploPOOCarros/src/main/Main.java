package main;

import automoveis.Carro;

public class Main
{
    public static void main(String[] args)
    {
        Carro kwid = new Carro();
        kwid.anoFabricacao = 2024;
        kwid.cor = "prata";
        kwid.anoModelo = 2024;
        kwid.modelo = "Kwid";
        kwid.fabricante = "Renault";
        kwid.qtdPortas = 4;

        Carro uno = new Carro();
        uno.anoFabricacao = 2020;
        uno.cor = "branco";
        uno.anoModelo = 2020;
        uno.modelo = "Uno";
        uno.fabricante = "Fiat";
        uno.qtdPortas = 2;
        uno.possuiEscada = true;


        System.out.printf("Fabricando do carro %s, modelo: %s, ano de fabricação: %d.%n", kwid.anoFabricacao, kwid.modelo, kwid.anoFabricacao);

        System.out.printf("Fabricando do carro %s, modelo: %s, ano de fabricação: %d.%n", uno.anoFabricacao, uno.modelo, uno.anoFabricacao, uno.possuiEscada);


        kwid.acelerar();
        uno.acelerar();
        kwid.businar();
        kwid.frear();


    }
}
