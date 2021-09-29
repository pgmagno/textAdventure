public class Room {

    String[] directions;
    String[] directionsOpened;
    String introduction;
    String[][] pointsOfInterest;
    boolean position;
    String[] solution;

    public Room (String[] directions, String[] directionsOpened, String introduction, String[][] pointsOfInterest, String[] solution, boolean position) {
        this.directions = directions;
        this.directionsOpened = directionsOpened;
        this.introduction = introduction;
        this.pointsOfInterest = pointsOfInterest;
        this.position = position;
        this.solution = solution;
    }

}
