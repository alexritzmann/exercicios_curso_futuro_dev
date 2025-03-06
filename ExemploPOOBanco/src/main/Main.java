package main;

import banco.Conta;

public class Main
{
    public static void main(String[] args)
    {
        Conta conta1 = new Conta();
        Conta conta2 = new Conta();


        conta1.nomeTitular = "Alex";
        conta1.saldo = 100.0;

        conta2.nomeTitular = "Giovanna";
        conta2.saldo = 500.0;

        System.out.println("Saldo de "+ conta1.nomeTitular + " é de " + conta1.saldoAtual());

        conta1.sacar(50);

        System.out.println("Sacado 50 da conta de " + conta1.nomeTitular);

        System.out.println("Saldo de "+ conta1.nomeTitular + " é de " + conta1.saldoAtual());

        //conta1.depositar(200);

        conta1.transferir(10, conta2);

        System.out.println("transferir 10 de " +conta1.nomeTitular+ " para " + conta2.nomeTitular);

        System.out.println("Saldo de "+ conta1.nomeTitular + " é de " + conta1.saldoAtual());
        System.out.println("Saldo de "+ conta2.nomeTitular + " é de " + conta2.saldoAtual());



    }
}
