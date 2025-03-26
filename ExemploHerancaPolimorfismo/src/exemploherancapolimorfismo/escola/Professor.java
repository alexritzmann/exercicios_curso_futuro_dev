package exemploherancapolimorfismo.escola;

public class Professor extends Funcionario
{
    private int horasAula;

    public int getHorasAula() {return horasAula;}
    public void setHorasAula(int horasAula) {this.horasAula = horasAula;}

    @Override
    public double getGastos()
    {
        return super.getSalario() + this.horasAula*10;
    }

    @Override
    public String getInfo()
    {
        String infoBasica = super.getInfo();
        String infoProfessor = infoBasica + " horas de aula: " + this.horasAula;
        return infoProfessor;
    }

}
