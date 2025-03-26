package exemploherancapolimorfismo.conta;

public class ContaInvestimento extends Conta implements Tributavel
{
    public double getValorImposto()
    {
        return super.getSaldo()*0.02;
    }
}
