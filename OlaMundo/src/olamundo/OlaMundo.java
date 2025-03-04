package olamundo;

public class OlaMundo {
    public static void main(String[] args)
    {
        System.out.println("Olá Mundo!");

        int anoNascimetno = 1986;
        System.out.println(anoNascimetno);

        char primeiraLetraDoNome = 'A';
        System.out.println(primeiraLetraDoNome);

        double altura = 1.75;
        System.out.println(altura);

        boolean ehNamorado = true;
        System.out.println(ehNamorado);

        altura = 1.77;
        System.out.println(altura);

        String nome = "Alex Ritzmann";
        System.out.println(nome);

        System.out.println("Nome do usuário: " + nome + ", nasceu em " + anoNascimetno);

        int numeroConvertido = (int) 5.69;
        System.out.println(numeroConvertido);

        System.out.printf("Nome: %s, Altura: %.2f metros %n Ano de nascimento: %d", nome, altura, anoNascimetno);


    }
}

