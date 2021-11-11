public class TurtleRoom extends Room {

    public TurtleRoom() {

    }

    public TurtleRoom(int roomNr, boolean isBooked, String roomName) {
        this.roomNr = roomNr;
        this.isBooked = isBooked;
        this.roomName = roomName;
    }

    public void describe() {
        System.out.println("\t Room [" + roomNr + "] for turtles, boxes with water and sand so they can swim and crawl around");
    }
}
