import java.util.ArrayList;

public class Labyrinth {

    Room[][] labyrinth = new Room[3][3];

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_ITABlue = "\u001B[36;3m";
    public static final String ANSI_ITAPurple = "\u001B[34;3m";

    ArrayList<String> playerInventory = new ArrayList<>();


    public Labyrinth() {
        labyrinth[0][0] = new Room(
                new String[]{},
                new String[]{"SUL", "LESTE"},
                "era ua vez...",
                new String [][] {{"SALA","Descrição do quarto após inspeção"},
                        {"PORTA","Uma porta de madeira maciça, você sente que somente um impacto enorme seria capaz de movê-la"}},
                new String[]{"EXPLOSIVO", "PORTA"},
                false);
        labyrinth[0][1] = new Room(
                new String[]{},
                new String[]{"OESTE", "LESTE"},
                "era ua vez...",
                new String [][] {{"SALA","Descrição do quarto após inspeção"},
                        {"PORTA","Uma porta de madeira maciça, você sente que somente um impacto enorme seria capaz de movê-la"}},
                new String[]{"EXPLOSIVO", "PORTA"},
                false);
        labyrinth[0][2] = new Room(
                new String[]{},
                new String[]{"SUL", "OESTE"},
                "era ua vez...",
                new String [][] {{"SALA","Descrição do quarto após inspeção"},
                        {"PORTA","Uma porta de madeira maciça, você sente que somente um impacto enorme seria capaz de movê-la"}},
                new String[]{"EXPLOSIVO", "PORTA"},
                false);
        labyrinth[1][0] = new Room(
                new String[]{},
                new String[]{"NORTE"},
                "era ua vez...",
                new String [][] {{"SALA","Descrição do quarto após inspeção"},
                        {"PORTA","Uma porta de madeira maciça, você sente que somente um impacto enorme seria capaz de movê-la"}},
                new String[]{"EXPLOSIVO", "PORTA"},
                false);
        labyrinth[1][1] = new Room(
                new String[]{},
                new String[]{"SUL", "LESTE"},
                "era ua vez...",
                new String [][] {{"SALA","Descrição do quarto após inspeção"},
                        {"PORTA","Uma porta de madeira maciça, você sente que somente um impacto enorme seria capaz de movê-la"}},
                new String[]{"EXPLOSIVO", "PORTA"},
                false);
        labyrinth[1][2] = new Room(
                new String[]{},
                new String[]{"NORTE", "SUL", "OESTE"},
                "era ua vez...",
                new String [][] {{"SALA","Descrição do quarto após inspeção"},
                        {"PORTA","Uma porta de madeira maciça, você sente que somente um impacto enorme seria capaz de movê-la"}},
                new String[]{"EXPLOSIVO", "PORTA"},
                false);
        labyrinth[2][0] = new Room(
                new String[]{},
                new String[]{"LESTE"},
                """
                        O quarto escuro a sua volta tem um cheiro fétido. O chão feito de pedras ásperas e
                        irregulares percorre toda a extensão do quarto. Não há nada em particular que chame atenção
                        senão uma pedra solta.""",
                new String [][] {{"SALA","Você encontra uma chave debaixo de uma pedra. Um bilhete diz: \"agora estamos quites.\"","Não"},
                                {"PORTA","Uma grade de metal, no meio uma fechadura de metal.", "Não"},
                                {"FECHADURA","metal enferrujado...", "Não"},
                                {"CHAVE", "uma chave comum", "Sim"}},
                new String[]{"CHAVE", "FECHADURA"},
                true);
        labyrinth[2][1] = new Room(
                new String[]{},
                new String[]{"NORTE", "OESTE"},
                "era ua vez...",
                new String [][] {{"SALA","Descrição do quarto após inspeção"},
                        {"PORTA","Uma porta de madeira maciça, você sente que somente um impacto enorme seria capaz de movê-la"}},
                new String[]{"EXPLOSIVO", "PORTA"},
                false);
        labyrinth[2][2] = new Room(
                new String[]{},
                new String[]{"NORTE"},
                "era ua vez...",
                new String [][] {{"SALA","Descrição do quarto após inspeção"},
                        {"PORTA","Uma porta de madeira maciça, você sente que somente um impacto enorme seria capaz de movê-la"}},
                new String[]{"EXPLOSIVO", "PORTA"},
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

    public ArrayList<String> checkInventory() {
        return playerInventory;
    }

}


