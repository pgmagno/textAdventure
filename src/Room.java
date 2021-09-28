public class Room {

    String[] directions;
    String objectInTheRoom;
    String introduction;
    String description;
    boolean position;

    public Room (String[] directions, String objectInTheRoom, String introduction, String description, boolean position) {
        this.directions = directions;
        this.objectInTheRoom = objectInTheRoom;
        this.introduction = introduction;
        this.description = description;
        this.position = position;
    }

}
