public class TurtleRoom extends Room {

    public TurtleRoom(String description, int roomNr) {
        this.description = description;
        this.roomNr = roomNr;

    }

    public void describe() {
        System.out.println("Room for turtles");
    }
}
