package banco;

public class Conta
{

    public String nomeTitular;
    public double saldo;

    public void sacar(double valor)
    {
        this.saldo = this.saldo - valor;
    }

    public double saldoAtual ()
    {
        return this.saldo;
    }

    public void depositar(double valor)
    {
        this.saldo = this.saldo + valor;
    }

    public void transferir (double valor, Conta contaCredito)
    {
        this.sacar(valor);
        contaCredito.depositar(valor);
    }

}
