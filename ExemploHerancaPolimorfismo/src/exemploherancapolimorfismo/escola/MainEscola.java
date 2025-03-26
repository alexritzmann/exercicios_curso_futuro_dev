package exemploherancapolimorfismo.escola;

public class MainEscola
{
    public static void main(String[] args)
    {
        GeradorRelatorio gr = new GeradorRelatorio();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Alex");
        funcionario.setSalario(500);

        Professor professor = new Professor();
        professor.setNome("Giovanna");
        professor.setSalario(500);
        professor.setHorasAula(40);

        Reitor reitor = new Reitor();
        reitor.setNome("Marcos");
        reitor.setSalario(600);
        reitor.setAdicionalCargo(600);
        reitor.setCargoConfiaca(true);


        gr.adiciona(funcionario);
        gr.adiciona(professor);
        gr.adiciona(reitor );
    }
}
