package exemploherancapolimorfismo.conta;

public class ContaCorrent extends Conta implements Tributavel
{
    private double limite;

    public double getLimite() {return limite;}
    public void setLimite(double limite) {this.limite = limite;}

    public double getSaldoComLimite()
    {
        return super.getSaldo() + this.limite;
    }

    @Override
    public double getSaldo()
    {
        return super.getSaldo()+this.limite;
    }

    public double getValorImposto()
    {
        return super.getSaldo()*0.01;
    }

}
