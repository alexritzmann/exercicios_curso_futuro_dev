package exemploherancapolimorfismo.conta;

public class MainPolimorfismo
{
    public static void main(String[] args)
    {
        ContaCorrent cc = new ContaCorrent();

        cc.setNomeTitular("Alex");
        cc.setSaldo(200);
        cc.setLimite(50);
        System.out.println("getsaldoCC "+cc.getSaldo());

        Conta conta = cc;
        System.out.println("getsaldoCONTA "+conta.getSaldo());

        conta.sacar(150);

        System.out.println("nome "+cc.getNomeTitular());
        System.out.println("getsaldo2 "+cc.getSaldo());
    }
}
