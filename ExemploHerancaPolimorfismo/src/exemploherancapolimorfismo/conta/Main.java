package exemploherancapolimorfismo.conta;

public class Main
{
    public static void main(String[] args)
    {
        ContaCorrent cc = new ContaCorrent();
        ContaPoupanca cp = new ContaPoupanca();

        cc.setNomeTitular("Alex");
        cc.setSaldo(50);
        System.out.println("nome "+cc.getNomeTitular());
        System.out.println("getsaldo1 "+cc.getSaldo());
        cc.setLimite(100);
        System.out.println("getlimite "+cc.getLimite());
        System.out.println("getsaldocomlimite "+cc.getSaldoComLimite());
        System.out.println("getsaldo2 "+cc.getSaldo());



        cp.setNomeTitular("Giovanna");
        cp.setSaldo(100);
        System.out.println("nome "+cp.getNomeTitular());
        System.out.println("getsaldo1 "+cp.getSaldo());


    }
}
