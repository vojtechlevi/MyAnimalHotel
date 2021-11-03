public class CatRoom extends Room {

    public CatRoom(int roomNr) {
        this.roomNr = roomNr;


    }

    public void describe() {
        System.out.println(" ");
        System.out.println("\t Room [" + roomNr + "] for cats, with boxes and loads of different food and toys");

    }

}
