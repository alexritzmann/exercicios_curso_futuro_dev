package verificaespecieestincao;

import java.util.Arrays;
import java.util.Scanner;

public class VerificaEspecieExtincao
{
    public static void main(String[] args)
    {
        System.out.println("Verificar Espécie em Perigo de Extinção");

        Scanner entrada = new Scanner(System.in);

        String[] animaisEmExtincao = new String[5];
        animaisEmExtincao[0] = "Ararajuba";
        animaisEmExtincao[1] = "Ariranha";
        animaisEmExtincao[2] = "Lobo-guará";
        animaisEmExtincao[3] = "Onça-Pintada";
        animaisEmExtincao[4] = "Cervo do Pantanal";

        Arrays.sort(animaisEmExtincao);

        System.out.println("Nesse aplicativo exitem 5 espécies de animais em extinção. \nDigite uma espécia que vou verificar se ela está em extinção para você:");
        String animalInformado = entrada.nextLine();

        boolean extincao = false;
        for (String animal : animaisEmExtincao) {
            if (animalInformado.trim().equalsIgnoreCase(animal.trim())) {
                System.out.println("O animal " + animalInformado.trim() + " está em perigo de extinção");
                extincao = true;
                break;
            }
        }

        if (!extincao)
        {
            System.out.println("O animal " + animalInformado.trim() + " NÃO está em perigo de extinção");
        }


    }
}
