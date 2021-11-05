public class DogRoom extends Room {


    public DogRoom(){

    }
    public DogRoom(int roomNr, boolean isBooked, String roomName) {
        this.roomNr = roomNr;
        this.isBooked = isBooked;
        this.roomName = roomName;

    }

    public void describe() {
        System.out.println("\t Room [" + roomNr + "] for dogs, with boxes and loads of different food and toys, \n\t also with a big yard where the dogs can run free");
    }


}
