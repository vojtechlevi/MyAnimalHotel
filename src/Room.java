public class Room {

    int roomNr;
    int roomBox;

    public Room(){

    }


    public int getRoomNr() {
        return roomNr;
    }
    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    public int getRoomBox() {
        return roomBox;
    }
    public void setRoomBox(int roomBox) {
        this.roomBox = roomBox;
    }

    public void describe() {
        System.out.println("\t Fresh and newly renovated rooms with boxes for dogs, cats & turtles");
    }

    @Override
    public String toString() {
        return " Room {" + "Room Nr = " + roomNr + '}' + "\n ";
    }

    /*
    public Room() {
  mainName = "k";

}

}
    private static void Initialise(Room[] myAnimalHotel) {


       for (Room : myAnimalHotel) {
           room.setName("nobody");
       }

}
    private static void BookARoom(Room[] myAnimalHotel, int roomNum) {
        String roomName;
        Scanner input = new Scanner(System.in);
        System.out.println("Please select a room 1, 2 or 3!");
        roomNum = input.nextInt() - 1;
        System.out.println("Enter your name for the room please " + (roomNum + 1) + ":");
        roomName = input.next();
        myAnimalHotel[roomNum].setName(roomName);
    }

     */
}
