public class Room {

    int roomNr;
    boolean isBooked;
    String roomName;
    Animal guest;

    public Room() {

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

}

