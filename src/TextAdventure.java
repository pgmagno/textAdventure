import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TextAdventure {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

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
        game.getDescription();

        Scanner playerInput = new Scanner(System.in);

        gameLoop:
        while (true) {

            String[] playerCommand = playerInput.nextLine().split(" ");
            for(int i = 0; i < playerCommand.length; i++) {
                playerCommand[i] = playerCommand[i].toUpperCase();
            }

            switch (playerCommand[0]) {
                case "IR":
                    game.setPosition(playerCommand[1]);
                    break;
                case "MAPA":
                    m.printMap();
                    break;
                case "DIREÇÕES":
                    System.out.println(Arrays.toString(game.getDirections()));
                    break;
                case "INSPECIONAR":
                    System.out.println(game.inspect());
                    break;
                case "SAIR":
                    System.out.println("Obrigado por Jogar");
                    break gameLoop;
                default:
                    System.out.println("Digite um comando válido");

            }
        }

    }
}
