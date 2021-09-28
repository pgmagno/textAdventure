public class Room {

    String[] directions = {"Norte", "Sul", "Oeste", "Leste"};
    String objectInTheRoom = "";
    String description = "";
    boolean position = false;

    public Room (String[] directions, String objectInTheRoom, String description, boolean position) {
        this.directions = directions;
        this.objectInTheRoom = objectInTheRoom;
        this.description = description;
        this.position = position;
    }

    public void setPosition () {
        this.position = true;
    }

    public void takeObjectInTheRoom() {
        this.objectInTheRoom = "Não há nada para pegar";
    }

}
