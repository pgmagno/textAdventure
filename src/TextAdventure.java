import java.util.Arrays;
import java.util.Scanner;

public class TextAdventure {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_ITABlue = "\u001B[36;3m";
    public static final String ANSI_ITAPurple = "\u001B[34;3m";



    public static void main(String[] args) {
        Labyrinth game = new Labyrinth();
        Map m = new Map(game.labyrinth);

        System.out.println("###############  Bem-vindo a aventura em texto Labirinto!  ###############");
        System.out.println("###############  Instruções  #############################################");
        System.out.println("O jogo se desenvolve através da interação com o terminal, lendo as descrições nele dispostas e");
        System.out.println("inserindo comandos e parâmetros a fim de realizar ações. Os comandos que você dispõe são:");
        System.out.println(ANSI_RED + "Ir " + ANSI_RESET + "- Move o player pelo jogo. Combine com uma direção (Norte, sul, leste ou oeste) a exemplo de: 'Ir Norte'");
        System.out.println(ANSI_RED + "Inspecionar " + ANSI_RESET + "- examina alguma coisa. Exemplo 'Inspecionar sala'");
        System.out.println(ANSI_RED + "Sair " + ANSI_RESET + "- encerra o jogo");
        System.out.println("Não se preocupe com a inserção de termos em caixa alta ou baixa. Apenas atente à escrita correta dos comandos");
        System.out.println("----------- GAME START! -----------");
        System.out.println();
        System.out.println();

        System.out.println(ANSI_ITABlue + "Você acorda em um quarto escuro e pequeno. Uma forte dor perfurante atravessa seu crânio.\n" +
                "Você aguarda alguns minutos naquele estado letárgico e pouco a pouco a sua memória começa a clarear. Ainda um pouco\n" +
                "desnorteado você se dá conta de que a última coisa que se lembra era de estar observando um estranho no canto da taverna.\n" +
                "Ele parecia familiar. Embora estivesse sozinho, parecia estar conversando com alguém. A partir daí você não se lembra de nada." + ANSI_RESET);

        System.out.println(ANSI_ITABlue + game.getIntroduction() + ANSI_RESET);

        Scanner playerInput = new Scanner(System.in);



        gameLoop:
        while (true) {

            System.out.println("O que você faz?");
            String[] playerCommand = playerInput.nextLine().split(" ");
            for(int i = 0; i < playerCommand.length; i++) {
                playerCommand[i] = playerCommand[i].toUpperCase();
            }

            if(playerCommand.length == 1) {

                switch (playerCommand[0]) {

                    case "MAPA":
                        m.printMap();
                        break;
                    case "DIREÇÕES":
                        System.out.println(Arrays.toString(game.getDirections()));
                        break;
                    case "INTRODUÇÃO":
                        System.out.println(ANSI_ITABlue + game.getIntroduction() + ANSI_RESET);
                        break;
                    case "INVENTÁRIO":
                        System.out.println(ANSI_ITABlue + game.checkInventory() + ANSI_RESET);
                        break;
                    case "SAIR":
                        System.out.println("Obrigado por Jogar");
                        break gameLoop;
                    case "AJUDA":
                        System.out.println(ANSI_RED + "Ir " + ANSI_RESET + "- Move o player pelo jogo. Combine com uma direção (Norte, sul, leste ou oeste) a exemplo de: 'Ir Norte'");
                        System.out.println(ANSI_RED + "Inspecionar " + ANSI_RESET + "- examina alguma coisa. Exemplo 'Inspecionar sala'");
                        System.out.println(ANSI_RED + "Mapa " + ANSI_RESET + "- exibe o mapa do jogo e sua localização atual.");
                        System.out.println(ANSI_RED + "Introdução " + ANSI_RESET + "- exibe a mensagem inicial da sala atual.");
                        System.out.println(ANSI_RED + "Sair " + ANSI_RESET + "- encerra o jogo");
                        break;
                    default:
                        System.out.println("Digite um comando válido");

                }

            } else {
                switch (playerCommand[0]) {
                    case "IR":
                        game.setPosition(playerCommand[1]);
                        break;
                    case "INSPECIONAR":
                        System.out.println(ANSI_ITAPurple + game.inspect(playerCommand[1]) + ANSI_RESET);
                        break;
                    case "PEGAR":
                        System.out.println(ANSI_ITAPurple + game.takeItem(playerCommand[1])+ ANSI_RESET);
                        break;
                    case "USAR":
                        System.out.println(ANSI_ITAPurple + game.trySolution(playerCommand[1],playerCommand[2])+ ANSI_RESET);
                        break;
                    case "SAIR":
                        System.out.println("Obrigado por Jogar");
                        break gameLoop;
                    default:
                        System.out.println("Digite um comando válido");
                }
                if (game.gameOver()){
                    break gameLoop;
                }
            }

        }

    }
}
