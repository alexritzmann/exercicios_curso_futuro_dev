package models;

public class Avaliacao
{
    private final int idAreaVerde;
    private final int notaQtdArvores;
    private final int notaQldAr;
    private final int notaAusenciaPoluicaoSonoroa;
    private final int notaColetaResiduos;
    private final int notaFacilidadeAcesso;
    private int idAvaliacao;

    public int getIdAreaVerde() {return idAreaVerde;}
    public void setIdAvaliacao(int idAvaliacao) {this.idAvaliacao = idAvaliacao;}

    public Avaliacao (int idAreaVerde, int notaQtdArvores, int notaQldAr, int notaAusenciaPoluicaoSonoroa, int notaColetaResiduos, int notaFacilidadeAcesso)
    {
        this.idAreaVerde = idAreaVerde;
        this.notaQtdArvores = notaQtdArvores;
        this.notaQldAr = notaQldAr;
        this.notaAusenciaPoluicaoSonoroa = notaAusenciaPoluicaoSonoroa;
        this.notaColetaResiduos = notaColetaResiduos;
        this.notaFacilidadeAcesso = notaFacilidadeAcesso;
    }

    public double calculaMediaAvaliacao()
    {
        return (notaQtdArvores + notaQldAr + notaAusenciaPoluicaoSonoroa + notaColetaResiduos + notaFacilidadeAcesso) / 5.0;
    }

    @Override
    public String toString()
    {
        return "Quantidade de Árvores: " + notaQtdArvores + "\n" +
                "Qualidade do Ar: " + notaQldAr + "\n" +
                "Ausência de Poluição Sonora: " + notaAusenciaPoluicaoSonoroa + "\n" +
                "Coleta de Resíduos: " + notaColetaResiduos + "\n" +
                "Facilidade de Acesso: " + notaFacilidadeAcesso + "\n" +
                "Média dessa avalição: " + calculaMediaAvaliacao() + "\n";
    }
}
