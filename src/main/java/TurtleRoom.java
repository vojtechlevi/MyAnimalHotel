public class TurtleRoom extends Room {

    // Denna klass ärver från klassen Room

    // Konstruktor som tar emot tre argument och sätter värdena till det specifika rummet

    public TurtleRoom(int roomNr, boolean isBooked, String roomName) {
        this.roomNr = roomNr;
        this.isBooked = isBooked;
        this.roomName = roomName;
    }
    // Overridar Room klassens metod describe()
    public void describe() {
        System.out.println("\t Room [" + roomNr + "] for turtles, boxes with water and sand so they can swim and crawl around");
    }
}
