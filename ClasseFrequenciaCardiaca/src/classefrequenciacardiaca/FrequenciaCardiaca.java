package classefrequenciacardiaca;

import java.util.Calendar;


public class FrequenciaCardiaca
{

    private int diaNascimento;
    private int mesNascimento;
    private int anoNascimento;
    private String nome;
    private String sobrenome;

    public int getDiaNascimento() {return diaNascimento;}

    public int getMesNascimento() {return mesNascimento;}

    public void setMesNascimento(int mesNascimento) {this.mesNascimento = mesNascimento;}

    public int getAnoNascimento() {return anoNascimento;}

    public void setAnoNascimento(int anoNascimento) {this.anoNascimento = anoNascimento;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getSobrenome() {return sobrenome;}

    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}

    public FrequenciaCardiaca(String nome, String sobrenome, int diaNascimento, int mesNascimento, int anoNascimento)
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.anoNascimento = anoNascimento;
        this.mesNascimento = mesNascimento;
        this.diaNascimento = diaNascimento;
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

    public void calculoFrequenciaCardiaca(int dia, int mes, int ano)
    {
        int idade = calcularIdade(dia, mes, ano);
        int frequencia = 220 - idade;

        System.out.println("Sua frequencia cardiaca máxima é de " + frequencia);

        System.out.println("O alvo da sua frenquencia cardiaca é estar entre " +frequencia*0.5 + " e " + frequencia*0.85);
    }


}
