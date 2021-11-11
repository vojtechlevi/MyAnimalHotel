public class CatRoom extends Room {


    public CatRoom(int roomNr, boolean isBooked, String roomName) {
        this.roomNr = roomNr;
        this.isBooked = isBooked;
        this.roomName = roomName;
    }

    public void describe() {
        System.out.println("\t Room [" + roomNr + "] for cats, with boxes and loads of different food and toys");

    }
}
