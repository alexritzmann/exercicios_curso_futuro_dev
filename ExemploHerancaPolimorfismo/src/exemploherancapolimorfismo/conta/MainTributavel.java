package exemploherancapolimorfismo.conta;

public class MainTributavel
{
    public static void main(String[] args)
    {
        Tributavel ti = new ContaInvestimento();

        ContaCorrent cc = new ContaCorrent();
        cc.setSaldo(500);

        ContaInvestimento ci = new ContaInvestimento();
        ci.setSaldo(100);

        ManipuladorTributaveis mt = new ManipuladorTributaveis();

        Tributavel[] bensTributaveis = new Tributavel[2];
        bensTributaveis[0] = cc;
        bensTributaveis[1] = ci;

        mt.calculaImpostos(bensTributaveis);

        System.out.println(mt.getTotal());



    }
}
