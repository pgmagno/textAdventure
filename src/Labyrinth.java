import java.util.Arrays;

public class Labyrinth {

    Room[][] labyrinth = new Room[3][3];
    public static final String	italicPurple = "\u001B[34;3m";
    public static final String	italicBlue = "\u001B[36;3m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Labyrinth () {
        labyrinth[0][0] = new Room(
                new String[] {"SUL", "LESTE"},
                "knife",
                "era ua vez...",
                false);
        labyrinth[0][1] = new Room(
                new String[] {"OESTE", "LESTE"},
                "knife",
                "era ua vez...",
                false);
        labyrinth[0][2] = new Room(
                new String[] {"SUL", "OESTE"},
                "knife",
                "era ua vez...",
                false);
        labyrinth[1][0] = new Room(
                new String[] {"NORTE"},
                "knife",
                "Você olha ao redor e não encontra nada",
                false);
        labyrinth[1][1] = new Room(
                new String[] {"SUL", "LESTE"},
                "knife",
                "era ua vez...",
                false);
        labyrinth[1][2] = new Room(
                new String[] {"NORTE", "SUL", "OESTE"},
                "knife",
                "era ua vez...",
                false);
        labyrinth[2][0] = new Room(
                new String[] {"LESTE"},
                "knife",
                "era ua vez...",
                true);
        labyrinth[2][1] = new Room(
                new String[] {"NORTE", "OESTE"},
                "knife",
                "era ua vez...",
                false);
        labyrinth[2][2] = new Room(
                new String[] {"NORTE"},
                "knife",
                "era ua vez...",
                false);
    }

    public String[] getDirections () {

        String[] directions = new String[4];

        loopDirection:
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                if (labyrinth[i][j].position) {
                   directions = labyrinth[i][j].directions;
                    break loopDirection;
                }
            }
        }
        return directions;
    }

    public void getDescription () {

        loopDescription:
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                if (labyrinth[i][j].position) {
                    System.out.println(italicBlue + labyrinth[i][j].description + ANSI_RESET);
                    break loopDescription;
                }
            }
        }

    }


    public int[] getCurrentPosition () {

        int[] position = new int [2];

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

    public void setPosition (String destino) {

        int[] position = getCurrentPosition();
        String[] directions = getDirections();
        int count = 0;
        for(String direction : directions) {
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

        if(finalPosition[0] > 2 || finalPosition[0] < 0 || finalPosition[1] < 0 || finalPosition[1] > 2) {
            System.out.println("Não é possível ir nessa direção!");
        }  else {
            labyrinth[position[0]][position[1]].position = false;
            labyrinth[finalPosition[0]][finalPosition[1]].position = true;
            System.out.println(labyrinth[finalPosition[0]][finalPosition[1]].description);
        }
    }

    public String inspect() {
        int[] position = getCurrentPosition();
        return labyrinth[position[0]][position[1]].objectInTheRoom;
    }




}


//System.out.print("Direções possíveis: ");
//        for(int k = 0; k < labyrinth[i][j].directions.length; k++) {
//        System.out.print(italicPurple + labyrinth[i][j].directions[k] + " " + ANSI_RESET);
//        }
//        System.out.println();
//        break loopDirection;