import java.util.Scanner;



public class Room {

    String description;
    int roomNr;


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getRoomNr() {
        return roomNr;
    }
    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    public void describe() {
        System.out.println("Description of the rooms:");
    }




    private String mainName;
    int animalsInRoom;

public Room() {
  mainName = "k";

}
public void setName(String aName) {


    mainName = aName;

}
public String getName() {

    return mainName;
}
   private static void Initialise(Room[] myAnimalHotel) {


       for (Room room : myAnimalHotel) {
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

}
