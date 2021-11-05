public class Room {

    int roomNr;
    boolean isBooked;
    String roomName;
    Animal guest;

    public Room(){

    }

    public int getRoomNr() {
        return roomNr;
    }
    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    public Animal getGuest() {
        return guest;
    }
    public void setGuest(Animal guest) {
        this.guest = guest;
    }

    public boolean getIsBooked() {
        return isBooked;
    }
    public void setIsBooked(boolean booked) {
        isBooked = booked;
    }

    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void describe() {
        System.out.println("\t Fresh and newly renovated rooms with boxes for dogs, cats & turtles");
    }

    public boolean isAvailable() {
        return guest == null;
    }

    @Override
    public String toString() {
        return "\t Room{" +
                "roomNr=" + roomNr +
                ", isBooked=" + isBooked +
                ", guest=" + guest +
                '}';
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
