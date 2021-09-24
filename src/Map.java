public class Map {


    Room[][] labyrinth = new Room[3][3];

    public void printMap () {
        labyrinth[0][0] = new Room(new char[]{'N', 'E'},"knife","era ua vez...",true);


        for (int i = 0; i < labyrinth.length; i++){
            for (int j = 0; j < labyrinth[0].length; j++) {
                System.out.print(" | ");
                System.out.println(labyrinth[i][j].directions);
            }
            System.out.println();

        }
    }


}
