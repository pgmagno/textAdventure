import java.util.ArrayList;

public class Labyrinth {

    Room[][] labyrinth = new Room[3][3];

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_ITABlue = "\u001B[36;3m";
    public static final String ANSI_ITAPurple = "\u001B[34;3m";

    ArrayList<String> playerInventory = new ArrayList<>();
    boolean endGame = false;


    public Labyrinth() {
        labyrinth[0][0] = new Room(
                new String[]{"SUL", "LESTE"},
                new String[]{"SUL", "LESTE"},
                "Ao atravessar a porta, você encontra uma sala estreita.",
                new String [][] {{"SALA","Não há nada aos lados, somente uma entrada ao sul","Não"},
                        {"PORTA","Uma porta ornamentada se apresenta a sua frente.", "Não"}},
                new String[]{},
                false);
        labyrinth[0][1] = new Room(
                new String[]{"OESTE", "LESTE"},
                new String[]{"OESTE", "LESTE"},
                "Voce atravessa a porta e encontra um corredor longo.",
                new String [][] {{"SALA","Ao fundo, uma porta. Nos lados, o quadro de um homem de uniforme.", "Não"},
                        {"PORTA","Uma porta comum.", "Não"},
                        {"QUADROS","O quadro parece ter sido recentemente pintado. A tinta parece ser óleo e ainda não secou totalmente.","Não"}
                },
                new String[]{},
                false);
        labyrinth[0][2] = new Room(
                new String[]{"SUL"},
                new String[]{"SUL", "OESTE"},
                "Você atravessagem a passagem esculpida na pedra e encontra uma quarto totalmente branco.",
                new String [][] {{"SALA","O quarto está totalmente limpo, existe uma porta à oeste. De cada lado, um botão.", "Não"},
                        {"PORTA","Uma porta feita de metal. Existe um mecanismo central que conecta os dois botões.","Não"},
                        {"BOTÃO", "Há somente uma indição Botão-alfa e Botão-ômega. Ao serem pressionados repetidamente, um som estridente se ouve.", "Não"},
                        {"BOTÕES", "Há somente uma indição Botão-alfa e Botão-ômega. Ao serem pressionados repetidamente, um som estridente se ouve.", "Não"},
                        {"BOTÃO-ALFA", "Um botão comum. A única coisa que chama atenção é a letra grega.", "Não"},
                        {"BOTÃO-ÔMEGA", "Um botão comum. A única coisa que chama atenção é a letra grega.", "Não"}
                },
                new String[]{"BOTÃO-ÔMEGA", "BOTÃO-ALFA", "Ao acionar os botões na ordem correta, a porta se abre."},
                false);
        labyrinth[1][0] = new Room(
                new String[]{},
                new String[]{"NORTE"},
                "Você entra na sala. É possível ouvir o som do vento lado de fora.",
                new String [][] {{"SALA","Você ", "Não"},
                        {"PORTA","Uma porta de madeira maciça, você sente que somente um impacto enorme seria capaz de movê-la", "Não"}},
                new String[]{"BOMBA", "PORTA", "Game over!"},
                false);
        labyrinth[1][1] = new Room(
                new String[]{"SUL"},
                new String[]{"SUL", "LESTE"},
                "Você atravessa pela porta e olha um corredor. Ao final, um curva à leste",
                new String [][] {{"SALA","""
                                            Ao andar pela sala nada em especial chama sua atenção. Você continua e
                                            vira a esquerda, você nota uma pequena escotilha com um mecanismo no canto
                                            inferior direito.""", "Não"},
                        {"ESCOTILHA","Uma porta pequena feita de metal maciço. Não se move ao empurrar.", "Não"},
                        {"MECANISMO", "Um mecanismo antigo e rústico. É possível ver um encaixe hexagonal.","Não"}
                },
                new String[]{"MANIVELA", "MECANISMO", "Você gira a manivela e a escotilha lentamente se abre."},
                false);
        labyrinth[1][2] = new Room(
                new String[]{"NORTE", "SUL", "OESTE"},
                new String[]{"NORTE", "SUL", "OESTE"},
                "Você passa pela escotilha e entra em uma sala. À norte, uma passagem; à sul, um portão.",
                new String [][] {{"SALA","Descrição do quarto após inspeção", "Não"},
                        {"PORTÃO","Um portão metálico reforçado, porém destrancado. ", "Não"},
                        {"PASSAGEM","Um buraco esculpido na pedra.", "Não"}
                },
                new String[]{},
                false);
        labyrinth[2][0] = new Room(
                new String[]{},
                new String[]{"LESTE"},
                """
                        O quarto escuro a sua volta tem um cheiro fétido. O chão feito de pedras ásperas e
                        irregulares percorre toda a extensão do quarto. Você está só. O zumbido estridente denuncia
                        a presença de um silência absoluto. Nada se ouve.""",
                new String [][] {{"SALA", """
                                            Ao inspecionar a sala você observa um pedra solta bem ao lado de onde você acordou.
                                            Ao movê-la, você encontra uma chave debaixo de uma pedra. Ao lado, um bilhete que diz:
                                            "agora estamos quites.\"""","Não"},
                                {"PORTA","Uma grade de metal, no meio uma fechadura de metal.", "Não"},
                                {"FECHADURA","metal enferrujado...", "Não"},
                                {"CHAVE", "uma chave comum", "Sim"}},
                new String[]{"CHAVE", "FECHADURA", "Com dificuldade você gira a chave e a porta se abre com um rangido..."},
                true);
        labyrinth[2][1] = new Room(
                new String[]{"NORTE", "OESTE"},
                new String[]{"NORTE", "OESTE"},
                """
                              Você atravessa a grade que divide as duas salas. O ar nesta parece mais límpido. Você
                              enche os pulmões e se sente ligeiramente recuperado.""",
                new String [][] {{"SALA","""
                                        Aqui já se pode ver um pouco melhor. A sala está totalmente vazia, senão por uma mesa
                                        no fundo e uma porta entreaberta na direção norte.""", "Não"},
                        {"PORTA","Uma porta de madeira comum.", "Não"},
                        {"MESA","Uma mesa metálica, sobre ela vários papéis velhos e uma manivela.","Não"},
                        {"MANIVELA", "Uma manivela enferrujada, o cabo está gasto mas o encaixe hexagonal aparenta estar em bom estado.", "Sim"}
                            },
                new String[]{},
                false);
        labyrinth[2][2] = new Room(
                new String[]{"NORTE"},
                new String[]{"NORTE"},
                "Você abre o portão e entra em uma sala pequena.",
                new String [][] {{"SALA","""
                        Várias prateleiras circundam toda a sala. Em uma delas,
                        um objeto metálico cintila com um brilho tênue. Trata-se de uma bomba.""","Não"},
                        {"BOMBA","Após inspecionar a bomba, você conclui que se trata de um artefato explosivo caseiro.", "Sim"}},
                new String[]{},
                false);
    }

    public int[] getCurrentPosition() {

        int[] position = new int[2];

        loopPosition:
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                if (labyrinth[i][j].position) {
                    position[0] = i;
                    position[1] = j;
                    break loopPosition;
                }
            }
        }
        return position;
    }


    public String[] getDirections() {

        int[] position = getCurrentPosition();

        return labyrinth[position[0]][position[1]].directions;
    }

    public String getIntroduction() {

        int[] position = getCurrentPosition();

        return labyrinth[position[0]][position[1]].introduction;
    }

    public void setPosition(String destino) {

        int[] position = getCurrentPosition();
        String[] directions = getDirections();
        int count = 0;
        for (String direction : directions) {
            if (destino.equals(direction)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Não é possível ir nessa direção");
            return;
        }


        int[] finalPosition = new int[2];

        switch (destino) {
            case "NORTE":
                finalPosition[0] = position[0] - 1;
                finalPosition[1] = position[1];
                break;
            case "SUL":
                finalPosition[0] = position[0] + 1;
                finalPosition[1] = position[1];
                break;
            case "LESTE":
                finalPosition[0] = position[0];
                finalPosition[1] = position[1] + 1;
                break;
            case "OESTE":
                finalPosition[0] = position[0];
                finalPosition[1] = position[1] - 1;
                break;

            default:
                System.out.println("Não é possível ir nessa direção");
        }

        if (finalPosition[0] > 2 || finalPosition[0] < 0 || finalPosition[1] < 0 || finalPosition[1] > 2) {
            System.out.println("Não é possível ir nessa direção!");
        } else {
            labyrinth[position[0]][position[1]].position = false;
            labyrinth[finalPosition[0]][finalPosition[1]].position = true;
            System.out.println(ANSI_ITABlue + labyrinth[finalPosition[0]][finalPosition[1]].introduction + ANSI_RESET);
        }
    }

    public String inspect(String pointOfInterest) {

        int[] position = getCurrentPosition();
        String resultOfInspection = "";

        if (playerInventory.size() > 0) {

            for (int p = 0; p < playerInventory.size(); p++) {
                if (pointOfInterest.equals(playerInventory.get(p))) {
                    for(int i = 0; i < labyrinth.length; i++) {
                        for (int j = 0; j < labyrinth[i].length; j++) {
                            for (int k = 0; k < labyrinth[i][j].pointsOfInterest.length; k++) {
                                if (pointOfInterest.equals(labyrinth[i][j].pointsOfInterest[k][0])) {
                                    resultOfInspection = labyrinth[i][j].pointsOfInterest[k][1];
                                    return resultOfInspection;
                                }
                            }
                        }
                    }
                }
            }

        }

        for(int i = 0; i < labyrinth[position[0]][position[1]].pointsOfInterest.length; i++) {
            if (pointOfInterest.equals(labyrinth[position[0]][position[1]].pointsOfInterest[i][0])) {
                resultOfInspection = labyrinth[position[0]][position[1]].pointsOfInterest[i][1];
            }
        }


        if (resultOfInspection.equals("")) {
            resultOfInspection = "Você examina minuciosamente, mas nada chama a sua atenção.";
        }
        return resultOfInspection;
    }



    public String takeItem(String pointOfInterest) {
        int[] position = getCurrentPosition();

        String resultOfTaking ="";

        int counter = 0;
        if (playerInventory.size() > 0) {
            do {
                if (playerInventory.get(counter).equals(pointOfInterest)) {
                    resultOfTaking = "Você já pegou esse objeto.";
                    return resultOfTaking;
                }
                counter++;
            } while (counter < playerInventory.size());
        }

        for(int i = 0; i < labyrinth[position[0]][position[1]].pointsOfInterest.length; i++) {

            if (pointOfInterest.equals(labyrinth[position[0]][position[1]].pointsOfInterest[i][0]) &&
                    labyrinth[position[0]][position[1]].pointsOfInterest[i][2].equals("Sim")) {

                playerInventory.add(labyrinth[position[0]][position[1]].pointsOfInterest[i][0]);

                resultOfTaking = "Voce adicionou " + ANSI_ITABlue + labyrinth[position[0]][position[1]].pointsOfInterest[i][0] + ANSI_ITAPurple + " ao inventário.";
                break;
            } else if (pointOfInterest.equals(labyrinth[position[0]][position[1]].pointsOfInterest[i][0]) &&
                    labyrinth[position[0]][position[1]].pointsOfInterest[i][2].equals("Não")) {

                resultOfTaking = "Você não pode pegar isso.";
                break;
            } else {
                resultOfTaking = "Nada foi adicionado";

            }
        }
        System.out.println(playerInventory);
        return resultOfTaking;
    }

    public void unlockDoors (int pos1, int pos2) {
        int[] position = getCurrentPosition();
        labyrinth[pos1][pos2].directions = labyrinth[pos1][pos2].directionsOpened;
    }

    public ArrayList<String> checkInventory() {
        return playerInventory;
    }

    public String trySolution (String parameter, String parameter2) {
        int[] position = getCurrentPosition();

        String resultOfTrying;

        if (labyrinth[position[0]][position[1]].solution[0].equals(parameter)
            && labyrinth[position[0]][position[1]].solution[1].equals(parameter2)){

            unlockDoors(position[0], position[1]);
            resultOfTrying = labyrinth[position[0]][position[1]].solution[2];
        } else {
            resultOfTrying = "Nada acontece.";
        }

        if (resultOfTrying.equals("Game over!")) {

            endGame = true;
        }

        return resultOfTrying;
    }

    public boolean gameOver() {
       if (endGame) {
           System.out.println("Após a fumaça clarear, uma brisa fresca invade a os escombros da saída forçada. Parabéns, você escapou!");
           System.out.println("Obrigado por jogar!");
       }
            return endGame;
    }
}




