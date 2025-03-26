package Main;

import Repositorios.AreaVerdeRepository;
import Repositorios.AvaliacaoRepository;
import Repositorios.LocalizacaoRepository;
import models.AreaVerde;
import models.Avaliacao;
import models.Localizacao;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        AreaVerdeRepository areaVerdeRepository = new AreaVerdeRepository();
        LocalizacaoRepository localizacaoRepository = new LocalizacaoRepository();
        AvaliacaoRepository avaliacaoRepository = new AvaliacaoRepository();
        Scanner entrada = new Scanner(System.in);

        int operacao;

        bemVindo();
        do
        {
            menu();
            testaEntradaMenu(entrada);
            operacao = entrada.nextInt();
            entrada.nextLine();

            switch (operacao)
            {
                case 1: cadastrar(entrada, areaVerdeRepository, localizacaoRepository); break;
                case 2: listar(areaVerdeRepository, avaliacaoRepository); break;
                case 3: avaliar(entrada, areaVerdeRepository, avaliacaoRepository); break;
                case 4: detalhar(entrada, areaVerdeRepository, localizacaoRepository, avaliacaoRepository); break;
                case 0: sair(); break;
                default: mensagemDefault(); break;
            }
        }while (operacao !=0);

    }

    public static void menu ()
    {
        System.out.println("Escolha o número referente a uma opção e aperte enter:");
        System.out.println("1 -> Cadastrar nova Área Verde");
        System.out.println("2 -> Listar Áreas Verdes cadastradas");
        System.out.println("3 -> Avaliar uma Área Verde");
        System.out.println("4 -> Detalhar uma Área Verdade específica");
        System.out.println("0 -> Sair");
        System.out.print("Opção escolhida: ");
    }

    public static void cadastrar (Scanner entrada, AreaVerdeRepository areaVerdeRepository, LocalizacaoRepository localizacaoRepository)
    {
        System.out.println("Cadastrar nova Área Verde\n");
        System.out.println("Para cadadastrar uma nova Área Verde é necessário informar alguns dados. Vamos lá!");

        System.out.print("Nome da Área Verde: ");
        String nome = testaEntradaString(entrada);
        double latitude;
        while(true)
        {
            System.out.print("Latitude da Área Verde (entre 0 e 90): ");
            latitude = testaEntradaDouble(entrada);
            if (latitude >=0 && latitude <= 90)
            {
                break;
            }else
            {
                System.out.print("Tente novamente!\n");
            }
        }

        int latitudeNorteSul;
        while(true)
        {
            System.out.print("Ao Norte ou ao Sul? Digite: \n1 -> Norte\n2 -> Sul\n");
            System.out.print("Opção escolhida: ");
            latitudeNorteSul = testaEntradaInt(entrada);
            if (latitudeNorteSul >=1 && latitudeNorteSul <= 2)
            {
                break;
            }else
            {
                System.out.print("Tente novamente!\n");
            }
        }

        double longitude;
        while(true)
        {
            System.out.print("Longitude da Área Verde (entre 0 e 180): ");
            longitude = testaEntradaDouble(entrada);
            if (longitude >=0 && longitude <= 180)
            {
                break;
            }else
            {
                System.out.print("Tente novamente!\n");
            }
        }

        int longitudeLesteOeste;
        while(true)
        {
            System.out.print("Ao Leste ou ao Oeste? Digite: \n1 -> Leste\n2 -> Oeste\n");
            System.out.print("Opção escolhida: ");
            longitudeLesteOeste = testaEntradaInt(entrada);
            if (longitudeLesteOeste >=1 && longitudeLesteOeste <= 2)
            {
                break;
            }else
            {
                System.out.print("Tente novamente!\n");
            }
        }

        System.out.print("Qual principal tipo de vegetação (árvores, arbustos, grama/gramado): ");
        String tipoVegetacao = testaEntradaString(entrada);

        int respostaHorario;
        boolean vinteQuatroHoras;
        String horarioInicial = "";
        String horarioFinal = "";
        while(true)
        {
            System.out.print("Está aberto 24 horas?\n1 -> Sim\n2 -> Não\n");
            System.out.print("Opção escolhida: ");
            respostaHorario = testaEntradaInt(entrada);
            if (respostaHorario == 1)
            {
                vinteQuatroHoras = true;
                break;
            }else if(respostaHorario == 2)
            {
                vinteQuatroHoras = false;
                System.out.print("Qual horário de abertura?: ");
                horarioInicial = testaEntradaString(entrada);
                System.out.print("Qual horário de encerramento?: ");
                horarioFinal = testaEntradaString(entrada);
                break;
            }else
            {
                System.out.print("Tente novamente!\n");
            }
        }

        ArrayList<String> atividades = new ArrayList<>();
        System.out.print("Quais atividades são oferecidas? \n");
        System.out.print("Exemplos: caminhada, ciclismo, futebol, vôlei, quadras de areia, piquenique, parquinho infantil, pedalinho, etc \n");
        while (true)
        {
            System.out.print("Atividade: ");
            atividades.add(testaEntradaString(entrada));
            System.out.print("Adicionar mais atividades?\n1 -> Sim\n2 -> Não\n");
            System.out.print("Opção escolhida: ");
            int resposta = testaEntradaInt(entrada);
            if (resposta == 2)
            {
                break;
            }else if (resposta != 1)
            {
                System.out.print("Tente novamente!\n");
            }
        }

        AreaVerde novaAV = new AreaVerde(nome,tipoVegetacao,vinteQuatroHoras,horarioInicial,horarioFinal,atividades);
        areaVerdeRepository.salvarAreaVerde(novaAV);
        Localizacao novaLocalizacao = new Localizacao(novaAV.getIdAreaVerde(), latitude, latitudeNorteSul, longitude, longitudeLesteOeste);
        localizacaoRepository.salvarLocalizacao(novaLocalizacao);

        System.out.println("Área Verde cadastrada com sucesso!\n");
    }

    public static void listar(AreaVerdeRepository areaVerdeRepository, AvaliacaoRepository avaliacaoRepository)
    {
        System.out.println("Listar Áreas Verdes cadastradas\n");
        areaVerdeRepository.listarTodasAreasVerdes(avaliacaoRepository);
        System.out.println();
    }

    public static void avaliar(Scanner entrada, AreaVerdeRepository areaVerdeRepository, AvaliacaoRepository avaliacaoRepository)
    {
        System.out.println("Avaliar uma Área Verde\n");

        if (areaVerdeRepository.quantidadeAreasVerdes() == 0)
        {
            System.out.println("Não há áreas verdes cadastradas. Cadastre uma área verde antes de avaliar.\n");
            return;
        }

        int escolha;
        while(true)
        {
            System.out.println("Informe qual ID da Área Verde deseja avaliar. (Digite zero para voltar)");
            System.out.print("ID escolhido: ");
            escolha = testaEntradaInt(entrada);
            if(escolha ==0)
            {
                System.out.println();
                return;
            }
            if (escolha >=1 && escolha <= areaVerdeRepository.quantidadeAreasVerdes())
            {
                AreaVerde areaVerde = areaVerdeRepository.localizarAreaVerde(escolha);
                if(areaVerde != null)
                {
                    break;
                }else
                {
                    System.out.print("Área Verde não localizada! Tente novamente.\n");
                }
            }else
            {
                System.out.print("ID Inválido. Tente novamente!\n");
            }
        }

        System.out.println("Certo. Você irá avaliar a Área Verde "+ areaVerdeRepository.localizarAreaVerde(escolha) + "\n");
        System.out.println("As notas devem ser de 1 a 5. Sendo 1 a menor nota e 5 a maior nota. OK?");

        int notaArvore;
        while(true)
        {
            System.out.println("Qual a nota para a QUANTIDADE DE ÁRVORES na Área Verde?");
            System.out.print("Nota: ");
            notaArvore = testaEntradaInt(entrada);
            if (notaArvore >=1 && notaArvore <= 5)
            {
                break;
            }else
            {
                System.out.print("Tente novamente!\n");
            }
        }

        int notaQldAr;
        while(true)
        {
            System.out.println("Qual a nota para a QUALIDADE DO AR na Área Verde?");
            System.out.print("Nota: ");
            notaQldAr = testaEntradaInt(entrada);
            if (notaQldAr >=1 && notaQldAr <= 5)
            {
                break;
            }else
            {
                System.out.print("Tente novamente!\n");
            }
        }

        int notaPoluicaoSonora;
        while(true)
        {
            System.out.println("Qual a nota para a POLUICAO SONORA na Área Verde? (quanto maior a note, menor a poluição sonora)");
            System.out.print("Nota: ");
            notaPoluicaoSonora = testaEntradaInt(entrada);
            if (notaPoluicaoSonora >=1 && notaPoluicaoSonora <= 5)
            {
                break;
            }else
            {
                System.out.print("Tente novamente!\n");
            }
        }

        int notaColetaResiduos;
        while(true)
        {
            System.out.println("Qual a nota para a COLETA DE RESÍDUOS na Área Verde?");
            System.out.print("Nota: ");
            notaColetaResiduos = testaEntradaInt(entrada);
            if (notaColetaResiduos >=1 && notaColetaResiduos <= 5)
            {
                break;
            }else
            {
                System.out.print("Tente novamente!\n");
            }
        }

        int notaFacilidadeAcesso;
        while(true)
        {
            System.out.println("Qual a nota para a FACILIDADE DE ACESSO UTLIZANDO TRANSPORTE PÚBLICO na Área Verde?");
            System.out.print("Nota: ");
            notaFacilidadeAcesso = testaEntradaInt(entrada);
            if (notaFacilidadeAcesso >=1 && notaFacilidadeAcesso <= 5)
            {
                break;
            }else
            {
                System.out.print("Tente novamente!\n");
            }
        }

        Avaliacao novaAvaliacao = new Avaliacao(escolha, notaArvore, notaQldAr, notaPoluicaoSonora, notaColetaResiduos, notaFacilidadeAcesso);
        avaliacaoRepository.salvarAvaliacoes(novaAvaliacao);

        System.out.println("Avaliação registrada com sucesso!\n");
    }

    public static void detalhar(Scanner entrada, AreaVerdeRepository areaVerdeRepository, LocalizacaoRepository localizacaoRepository, AvaliacaoRepository avaliacaoRepository)
    {
        System.out.println("Detalhar uma Área Verde específica\n");

        if (areaVerdeRepository.quantidadeAreasVerdes() == 0)
        {
            System.out.println("Não há áreas verdes cadastradas. Cadastre uma área verde antes de detalhar.\n");
            return;
        }

        int escolha;
        while(true)
        {
            System.out.println("Informe qual ID da Área Verde deseja detalhar. (Digite zero para voltar)");
            System.out.print("ID escolhido: ");
            escolha = testaEntradaInt(entrada);
            if(escolha ==0)
            {
                System.out.println();
                return;
            }
            if (escolha >=1 && escolha <= areaVerdeRepository.quantidadeAreasVerdes())
            {
                AreaVerde areaVerde = areaVerdeRepository.localizarAreaVerde(escolha);
                if(areaVerde != null)
                {
                    Localizacao localizacao = localizacaoRepository.localizarPorIdAreaVerde(escolha);
                    ArrayList<Avaliacao> avaliacoes = avaliacaoRepository.obterAvaliacoesPorAreaVerde(escolha);

                    System.out.println("\nVamos aos detalhes sobre a Área Verde:");
                    System.out.println(areaVerde.toStringDetalhado());
                    System.out.println(localizacao.toString());
                    if (avaliacoes.isEmpty())
                    {
                        System.out.println("Nenhuma avaliação registrada.");
                    } else
                    {
                        System.out.println("Avaliações:");
                        for (Avaliacao avaliacao : avaliacoes)
                        {
                            System.out.println(avaliacao.toString());
                        }
                    }
                    double notaGeral = avaliacaoRepository.calcularMediaGeral(escolha);
                    System.out.println("Nota geral da Área Verde: " + notaGeral + "\n\n");
                    break;

                }else
                {
                    System.out.print("Área Verde não localizada! Tente novamente.\n");
                }
            }else
            {
                System.out.print("ID Inválido. Tente novamente!\n");
            }
        }
    }

    public static void sair()
    {
        System.out.println("Obrigado por nos ajudar a cadastrar as Áreas Verdes da nossa cidade. Até logo.\n");
    }

    public static void mensagemDefault()
    {
        System.out.println("Desculpe, não encontrei essa opção.\n");
    }

    public static void bemVindo()
    {
        System.out.println("\nSeja bem vindo à Joinville");
        System.out.println("Neste aplicativo, vamos cadastrar, ver notas, localizar e muito mais sobre as áreas verdes da nossa cidade.");
        System.out.println("Vamos lá?\n");
    }

    public static void testaEntradaMenu(Scanner entrada)
    {
        while (!entrada.hasNextInt())
        {
            System.out.println("Nosso aplicativo não tem essa opção.\n");
            menu();
            entrada.next();
        }
    }

    public static int testaEntradaInt(Scanner entrada)
    {
        int valor;
        while (true)
        {
            if (entrada.hasNextInt())
            {
                valor = entrada.nextInt();
                entrada.nextLine();
                return valor;
            }
            else
            {
                System.out.print("Não existe essa opção.\nTente Novamente: ");
                entrada.next();
            }
        }
    }

    public static String testaEntradaString(Scanner entrada)
    {
        String testaString;
        do
        {
            testaString = entrada.nextLine().trim();
            if (testaString.isEmpty())
            {
                System.out.println("Essa informação não pode ser vazia. Tente novamente.");
            }
        }while (testaString.isEmpty());
        return testaString;
    }

    public static double testaEntradaDouble(Scanner entrada)
    {
        double testaDouble;
        while (true)
        {
            String strTestaString = entrada.nextLine().replace(",",".");
            try
            {
                testaDouble = Double.parseDouble(strTestaString);
                return testaDouble;
            }catch (NumberFormatException e)
            {
                System.out.print("Não existe essa opção.\nTente Novamente: ");
            }
        }
    }
}
