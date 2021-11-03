public class DogRoom extends Room {

    public DogRoom(int roomNr, int roomBox) {
        this.roomNr = roomNr;
        this.roomBox = roomBox;


    }

    public void describe() {
        System.out.println(" ");
        System.out.println("\t Room [" + roomNr + "] for dogs, with boxes and loads of different food and toys, \n\t also with a big yard where the dogs can run free");
    }


}
