package emissaodecarbono;

public class EmissaoDeCarbono
{
    private final String atividade;
    private final double quantidadeEmissao;

    public EmissaoDeCarbono (String nomeAtividade, double quantidade)
    {
        this.atividade = nomeAtividade;
        this.quantidadeEmissao = quantidade;
    }

    public void calcularEmissaoCO2(double minutos)
    {
        double horas = minutos / 60.0; // Converte minutos para horas
        double emissaoTotal = this.quantidadeEmissao * horas;
        System.out.println(this.atividade + " emite " + emissaoTotal + " kg de CO2 em " + minutos + " minutos.");
    }

}
