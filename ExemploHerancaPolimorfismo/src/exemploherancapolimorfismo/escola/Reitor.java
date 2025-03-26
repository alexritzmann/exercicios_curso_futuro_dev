package exemploherancapolimorfismo.escola;

import exemploherancapolimorfismo.escola.Funcionario;

public class Reitor extends Funcionario
{
    private boolean cargoConfiaca;
    private double adicionalCargo;

    public boolean isCargoConfiaca() {return cargoConfiaca;}
    public void setCargoConfiaca(boolean cargoConfiaca) {this.cargoConfiaca = cargoConfiaca;}
    public double getAdicionalCargo() {return adicionalCargo;}
    public void setAdicionalCargo(double adicionalCargo) {this.adicionalCargo = adicionalCargo;}

    @Override
    public double getGastos()
    {
        return super.getSalario() + this.adicionalCargo;
    }

    @Override
    public String getInfo()
    {
        String infoBasica = super.getInfo();
        String infoReitor = infoBasica + "\nÉ Reitor? " + isCargoConfiaca() + "\nValor adicional no salario: " + getAdicionalCargo();
        return infoReitor;
    }



}
