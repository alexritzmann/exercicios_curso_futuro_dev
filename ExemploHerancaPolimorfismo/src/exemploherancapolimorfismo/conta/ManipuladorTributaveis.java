package exemploherancapolimorfismo.conta;

public class ManipuladorTributaveis
{
    private double total;

    public double getTotal() {return total;}
    public void setTotal(double total) {this.total = total;}

    public void calculaImpostos(Tributavel[] bens)
    {
        for (Tributavel bem : bens)
        {
            this.total += bem.getValorImposto();
        }
    }
}
