package perfildesaude;

import java.util.Calendar;

public class PerfilDeSaude
{

    private String nome;
    private String sobrenome;
    private boolean sexo;
    private int anoNascimento;
    private int mesNascimento;
    private int diaNascimento;
    private double altura; // metros
    private double peso; // kg

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getSobrenome() {return sobrenome;}

    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}

    public boolean isSexo() {return sexo;}

    public void setSexo(boolean sexo) {this.sexo = sexo;}

    public int getAnoNascimento() {return anoNascimento;}

    public void setAnoNascimento(int anoNascimento) {this.anoNascimento = anoNascimento;}

    public int getMesNascimento() {return mesNascimento;}

    public void setMesNascimento(int mesNascimento) {this.mesNascimento = mesNascimento;}

    public int getDiaNascimento() {return diaNascimento;}

    public void setDiaNascimento(int diaNascimento) {this.diaNascimento = diaNascimento;}

    public double getAltura() {return altura;}

    public void setAltura(double altura) {this.altura = altura;}

    public double getPeso() {return peso;}

    public void setPeso(double peso) {this.peso = peso;}

    public PerfilDeSaude(String nome, String sobrenome, boolean sexo, int anoNascimento, int mesNascimento, int diaNascimento, double altura, double peso)
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.anoNascimento = anoNascimento;
        this.mesNascimento = mesNascimento;
        this.diaNascimento = diaNascimento;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIdade(int dia, int mes, int ano)
    {
        Calendar hoje = Calendar.getInstance();
        int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);
        int mesAtual = hoje.get(Calendar.MONTH) + 1;
        int anoAtual = hoje.get(Calendar.YEAR);
        int idade = anoAtual - ano;

        if (mesAtual < mes || (mesAtual == mes && diaAtual < dia))
        {
            idade--;
        }
        return idade;
    }

    public void calcularFrequenciaCardiaca(int dia, int mes, int ano)
    {
        int idade = calcularIdade(dia, mes, ano);
        int frequencia = 220 - idade;

        System.out.println("Sua frequencia cardiaca máxima é de " + frequencia);

        System.out.println("O alvo da sua frenquencia cardiaca é estar entre " +frequencia*0.5 + " e " + frequencia*0.85);
    }

    public String verficaSexo(boolean sex)
    {
        String sexo;
        if (sex)
        {
            sexo = "Feminino";
        }else
        {
            sexo = "Masculino";
        }
        return sexo;

    }


    public double calcularIMC(double peso, double altura)
    {
        double imc = (peso)/(altura*altura);
        return imc;
    }


}
