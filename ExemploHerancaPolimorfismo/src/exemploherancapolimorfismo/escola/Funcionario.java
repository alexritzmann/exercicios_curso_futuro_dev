package exemploherancapolimorfismo.escola;

public class Funcionario
{
    private String nome;
    private double salario;

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public double getSalario() {return salario;}
    public void setSalario(double salario) {this.salario = salario;}

    public double getGastos()
    {
        return this.salario;
    }

    public String getInfo()
    {
        return "Funcionário " + this.nome + " tem salario de " + this.salario;
    }
}
