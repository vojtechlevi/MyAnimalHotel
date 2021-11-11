public class Room {

    // Tre olika datatyper och en klass attribut
    int roomNr;
    boolean isBooked;
    String roomName;
    Animal guest;

    public Room() {

    }

    // Getter & Setter metoder för de olika attributen
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

    // Metod som skriver ut generell beskrivning utav rummen
    // Overridas av child-klasserna
    public void describe() {
        System.out.println("\t Fresh and newly renovated rooms with boxes for dogs, cats & turtles");
    }

}

