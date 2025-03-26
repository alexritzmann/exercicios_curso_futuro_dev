package exemploherancapolimorfismo.conta;

public class Conta
{
    private String nomeTitular;
    private double saldo;

    public void setNomeTitular(String nomeTitular) {this.nomeTitular = nomeTitular;}
    public void setSaldo(double saldo) {this.saldo = saldo;}
    public double getSaldo() {return this.saldo;}
    public String getNomeTitular() {return nomeTitular;}

    public void sacar(double valor)
    {
        this.saldo = this.saldo - valor;
    }



    public void depositar (double valor)
    {

    }
}
