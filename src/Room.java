public class Room {

    String[] directions;
    String[] directionsOpened;
    String introduction;
    String[][] description;
    boolean position;
    String[] solution;

    public Room (String[] directions, String[] directionsOpened, String introduction, String[][] description, String[] solution, boolean position) {
        this.directions = directions;
        this.directionsOpened = directionsOpened;
        this.introduction = introduction;
        this.description = description;
        this.position = position;
        this.solution = solution;
    }

}
