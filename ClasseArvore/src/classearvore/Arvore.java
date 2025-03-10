package classearvore;

public class Arvore
{
    private final String nomeArvore;
    private final String tipoArvore;
    private final double alturaArvore;

    public Arvore (String nome, String tipo, double altura)
    {
        this.nomeArvore = nome;
        this.tipoArvore = tipo;
        this.alturaArvore = altura;
    }

    public void exibirInformacoes()
    {
        System.out.println("A arvore escolhida tem as seguintes características: \nNome: " + this.nomeArvore + "\nTipo: " + this.tipoArvore + "\nAltura: " + this.alturaArvore);
    }

    public void calcularOxigenio()
    {
        double alutraEmCentimetros = this.alturaArvore*100;
        System.out.println("A arvore " + this.nomeArvore + " produz " + alutraEmCentimetros/10 + " gramas de oxigênio por dia");
    }




}
