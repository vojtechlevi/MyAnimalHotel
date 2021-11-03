public class TurtleRoom extends Room {

    public TurtleRoom(int roomNr) {
        this.roomNr = roomNr;


    }

    public void describe() {
        System.out.println(" ");
        System.out.println("\t Room [" + roomNr + "] for turtles, boxes with water and sand so they can swim and crawl around");
    }


}
