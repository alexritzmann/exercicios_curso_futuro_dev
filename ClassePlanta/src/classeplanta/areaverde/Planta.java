package classeplanta.areaverde;

public class Planta
{
    private String nome;
    private String tipo;
    private double necessidadeDeAgua;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getNecessidadeDeAgua() {
        return necessidadeDeAgua;
    }

    public void setNecessidadeDeAgua(double necessidadeDeAgua) {
        this.necessidadeDeAgua = necessidadeDeAgua;
    }



    public double calcularNecessidadeDeAgua(int qtdSemanas)
    {
        double qtdDeIrrigacao = qtdSemanas*this.necessidadeDeAgua;
        return qtdDeIrrigacao;
    }

    public void irrigar()
    {
        System.out.println("Planta irrigada com sucesso");
    }


}
