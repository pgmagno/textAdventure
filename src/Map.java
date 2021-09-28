public class Map {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_UNDERSCORE = "\u001B[0;4m";

    Room[][] labyrinth;

    public Map (Room[][] labyrinth) {
        this.labyrinth = labyrinth;
    }

    public void  printMap () {

        for (int i = 0; i < labyrinth.length; i++){
            for (int j = 0; j < labyrinth[0].length; j++) {

                if (labyrinth[i][j].position) {
                    System.out.print(ANSI_UNDERSCORE + "[" + ANSI_RED + " * " + ANSI_RESET + ANSI_UNDERSCORE + "]" + ANSI_RESET);
                } else {
                    System.out.print(ANSI_UNDERSCORE + "[   ]" + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }


}
