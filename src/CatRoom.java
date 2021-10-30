public class CatRoom extends Room {

    public CatRoom(String description, int roomNr) {
        this.description = description;
        this.roomNr = roomNr;

    }

    public void describe() {
        System.out.println("Room for cats");

    }
}
