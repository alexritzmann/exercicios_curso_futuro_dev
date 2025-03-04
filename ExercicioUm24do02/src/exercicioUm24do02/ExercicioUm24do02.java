package exercicioUm24do02;

import java.util.Scanner;

public class ExercicioUm24do02
{
    public static void main(String[] args)
    {
        System.out.println("Exercício UM do dia 24/02");
        Scanner entrada = new Scanner(System.in);

        String[][] listaAlunos = new String[5][2];
        int j;

        for (int i = 0; i<listaAlunos.length; i++)
        {
            j=0;
            System.out.println("Informe o nome do aluno 0" + (i+1) +": ");
            listaAlunos[i][j] = entrada.nextLine();
            j=1;
            double mediaIndividual = -1;
            while (mediaIndividual < 0 || mediaIndividual > 10)
            {
                System.out.println("Informe a média do aluno 0" + (i+1) +": (entre 0 e 10)");
                while (true)
                {
                    listaAlunos[i][j] = entrada.nextLine().replace(",",".");
                    String strMediaValida = listaAlunos[i][j];
                    try
                    {
                        mediaIndividual = Double.parseDouble(strMediaValida);
                        break;
                    }catch (NumberFormatException e)
                    {
                        System.out.println("Entrada Inválida. Informe a média do aluno 0" + (i+1) +": (entre 0 e 10)");
                    }
                }
                if (mediaIndividual < 0 || mediaIndividual > 10)
                {
                    System.out.println("Média fora dos limites. Informe a média do aluno 0" + (i+1) +": (entre 0 e 10)");
                }
            }
        }

        double maiorMedia =0;
        for (String[] listaAluno : listaAlunos) {
            double mediaAluno = Double.parseDouble(listaAluno[1]);
            if (mediaAluno > maiorMedia) {
                maiorMedia = mediaAluno;
            }
        }

        double menorMedia =10;
        for (String[] listaAluno : listaAlunos) {
            double mediaAluno = Double.parseDouble(listaAluno[1]);
            if (mediaAluno < menorMedia) {
                menorMedia = mediaAluno;
            }
        }

        double mediaTurma =0;
        for (String[] listaAluno : listaAlunos) {
            double mediaAluno = Double.parseDouble(listaAluno[1]);
            mediaTurma = mediaTurma + mediaAluno;
        }

        System.out.println("Aluno(s) com a maior média (" + maiorMedia + "):");
        for (String[] listaAluno : listaAlunos) {
            double mediaAtual = Double.parseDouble(listaAluno[1]);
            if (mediaAtual == maiorMedia) {
                System.out.println(listaAluno[0]);
            }
        }

        System.out.println("Aluno(s) com a menor média (" + menorMedia + "):");
        for (String[] listaAluno : listaAlunos) {
            double mediaAtual = Double.parseDouble(listaAluno[1]);
            if (mediaAtual == menorMedia) {
                System.out.println(listaAluno[0]);
            }
        }

        System.out.printf("Média da turma é: %.2f", mediaTurma/ listaAlunos.length);

    }
}
