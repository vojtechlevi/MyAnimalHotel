public class DogRoom extends Room {

    public DogRoom(String description, int roomNr) {
        this.description = description;
        this.roomNr = roomNr;

    }

    public void describe() {
        System.out.println("Room for dogs");
    }

}
