import java.util.ArrayList;
import java.util.Scanner;

public class AnimalHotel {

    ArrayList<Room> roomList; // Arraylist som ska lagra objekt av klassen Room
    Scanner inputScanner = new Scanner(System.in); // Scanner som lagrar inmatning från användaren
    public boolean runProgram = true;


    // Metod som hämtar inmatning utav strängar
    public String getUserString() {

        return inputScanner.nextLine();
    }

    // Metod som hämtar inmatning utav siffror
    public int getUserInt() {
        int myInt;
        while (true) {
            try {
                myInt = Integer.parseInt(inputScanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("\t Felaktigt menyval");
                System.out.println("\t > ");
            }
        }
        return myInt;
    }

    // Start Meny
    public void startMenu() {

        initRooms();

        while (runProgram) {
            System.out.println("___________________________________________________");
            System.out.println("\t   # Hello, Welcome to our Animal Hotel! #");
            System.out.println("\t # We have rooms for Dogs, Cats & Turtles #");
            System.out.println("\t    # Choose one of the options below # ");
            System.out.println(" ");
            System.out.println("\t [1] Continue to Main Menu");
            System.out.println("\t [2] Leave the hotel");
            System.out.println(" ");
            System.out.print("\t > ");
            int userInput = getUserInt();
            switch (userInput) {
                case 1 -> mainMenu();
                case 2 -> runProgram = false;
                default -> System.out.println("\t Sorry, try again!");
            }
        }
    }

    public void initRooms() {

        roomList = new ArrayList<Room>();
        Room DogRoom1 = new DogRoom(1,false, "Dog room");
        roomList.add(DogRoom1);

        Room CatRoom1 = new CatRoom(2, false, "Cat room");
        roomList.add(CatRoom1);

        Room TurtleRoom1 = new TurtleRoom(3, false, "Turtle room");
        roomList.add(TurtleRoom1);
    }

    // Huvud Meny
    public void mainMenu() {

        while (runProgram) {
            System.out.println("___________________________________________________");
            System.out.println("\t            # Main Menu #");
            System.out.println("\t    # What would you like to do? #");
            System.out.println(" ");
            System.out.println("\t [1] Animal Check-in");
            System.out.println("\t [2] Animal Check-out");
            System.out.println("\t [3] Update us on your pet");
            System.out.println("\t [4] See current bookings");
            System.out.println("\t [5] Leave the hotel");
            System.out.println(" ");
            System.out.print("\t > ");
            int userInput = getUserInt();
            switch (userInput) {
                case 1 -> animalCheckIn();
                case 2 -> animalCheckOut();
                case 3 -> animalUpdate();
                case 4 -> currentBookings();
                case 5 -> runProgram = false;
                default -> System.out.println("\t Sorry, try again!");
            }
        }
    }

    // Djur incheckning
    public void animalCheckIn() {

        Room mainRoom = new Room();
        Animal newAnimal = new Animal();
        Room newRoom;

        // Skriver ut generell rumsbeskrivning och frågar användaren vilket djur man vill boka för
        System.out.println("___________________________________________________");
        System.out.println("\t          # Animal Check-in #");
        System.out.println(" ");
        System.out.println("\t General Room Description: ");
        mainRoom.describe();
        System.out.println(" ");
        System.out.println("\t Which animal do you want to book a room for?");
        System.out.println(" ");
        System.out.print("\t > ");
        String userAnimal = getUserString().toLowerCase();

        // Om användaren skriver in Dog, dog, Cat, cat, Turtle, turtle fortsätter programmet
        // Annars skriv felmeddelande ut och metoden startar om.

        if (userAnimal.equals("dog") || userAnimal.equals("cat") || userAnimal.equals("turtle")) {
            System.out.println("\t Great, We love " + userAnimal + "'s!");
            System.out.println(" ");

        } else {
            System.out.println("\t Sorry, we cannot book a room for " + userAnimal + "'s...");
            System.out.println(" ");
            mainMenu();
        }

        // Frågar användaren vad djuret heter, vad djurets favorit mat är och vad djuret har för favoritaktivitet
        System.out.println("\t And what's the name of your " + userAnimal + "?");
        System.out.println(" ");
        System.out.print("\t > ");
        String animalName = getUserString();
        System.out.println("\t What a cute name, we look forward to meet " + animalName + "!");
        System.out.println("\t but first we need to know a few more things,");
        System.out.println(" ");
        System.out.println("\t What is " + animalName + "'s favorite food?");
        System.out.println(" ");
        System.out.print("\t > ");
        String animalFood = getUserString();
        System.out.println("\t We got plenty of " + animalFood + ", and are sure that " + animalName + " will enjoy the stay here!");
        System.out.println(" ");
        System.out.println("\t One last thing! what is " + animalName + "'s favorite activity?");
        System.out.println(" ");
        System.out.print("\t > ");
        String animalActivity = getUserString();
        System.out.println("\t Good to know that " + animalName + " likes " + animalActivity);

        // Beroende på vilket djur man checkar in (Dog, Cat, Turtle)
        // Så skapas ett objekt av det djuret och lagras i arraylist (Animal)
        if (userAnimal.equals("dog")) {
            newAnimal = new Dog(animalName, animalFood, animalActivity);
        }
        if (userAnimal.equals("cat")) {
            newAnimal = new Cat(animalName, animalFood, animalActivity);
        }
        if (userAnimal.equals("turtle")) {
            newAnimal = new Turtle(animalName, animalFood, animalActivity);
        }

        System.out.println(" ");
        System.out.println("\t Room List for available rooms");
        System.out.println("\t _______________________________________________");
        for (int i = 0; i < roomList.size(); i++){
            if(!roomList.get(i).getIsBooked()){
                System.out.println("\t Room name = " + roomList.get(i).getRoomName() + "\t Room Number = " + roomList.get(i).getRoomNr());
            }
        }

        // Olika val för rumsbokning
        System.out.println(" ");
        System.out.println("\t Which room would you like to book for your " + userAnimal + "?");
        System.out.println(" ");
        System.out.println("\t [1] Dog Room");
        System.out.println("\t [2] Cat Room");
        System.out.println("\t [3] Turtle Room");
        System.out.println(" ");
        System.out.print("\t > ");
        int userInput = getUserInt();

        // Beroende på vilket rum man vill boka för djuret så skapas det ett objekt av det rummet
        // och lagras i arraylist (Room), rumsbeskrivning skrivs ut
        if(userInput == 1){

            if(roomList.get(0).getIsBooked()){
                System.out.println(" ");
                System.out.println("\t This room is already booked");
            }else {
                roomList.get(0).setGuest(newAnimal);
                roomList.get(0).setIsBooked(true);
                System.out.println(" ");
                System.out.println("\t Room Description:");
                roomList.get(0).describe();
                System.out.println(" ");
                newAnimal.sayHello();
            }
        }
        if(userInput == 2){

            roomList.get(1).setGuest(newAnimal);
            roomList.get(1).setIsBooked(true);
            System.out.println(" ");
            System.out.println("\t Room Description:");
            roomList.get(1).describe();
            System.out.println(" ");
            newAnimal.sayHello();
        }
        if (userInput == 3){

            roomList.get(2).setGuest(newAnimal);
            roomList.get(2).setIsBooked(true);
            System.out.println(" ");
            System.out.println("\t Room Description:");
            roomList.get(2).describe();
            System.out.println(" ");
            newAnimal.sayHello();

        }

        // Användaren får val att gå tillbaka till huvud-menyn eller boka in ett nytt djur

        System.out.println(" ");
        System.out.println("\t [1] Back to Main Menu");
        System.out.println("\t [2] Check-in another animal");
        System.out.print("\t > ");
        userInput = getUserInt();
        switch (userInput) {
            case 1 -> mainMenu();
            case 2 -> animalCheckIn();
        }
    }

    // Djur utcheckning
    public void animalCheckOut() {

        // Frågar användaren efter djurets namn
        System.out.println("___________________________________________________");
        System.out.println("\t          # Animal Check-out #");
        System.out.println(" ");
        System.out.println("\t What is your pets name?");
        System.out.println(" ");
        System.out.print("\t > ");
        String animalName = getUserString();

        // Felmeddelande om hotellet är tomt

        // Kollar igenom djur listan
        // Om djurets namn finns inbokat
        // Skriver ut och tar bort bokningen
        // Annars skrivs det ut att namnet inte finns bokat
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getGuest() != null && animalName.equals(roomList.get(i).getGuest().getName())) {
                System.out.println(" ");
                System.out.println("\t We are sure that " + animalName + " had a great time being here!");
                System.out.println("\t Thanks you for booking at our Hotel!");
                roomList.get(i).setGuest(null);
                break;
            }else {
                System.out.println("\t Sorry, " + animalName + " haven't been booked here ");
            }
        }
    }

    // Djur uppdatering
    public void animalUpdate() {

        System.out.println("___________________________________________________");
        System.out.println("\t          # Animal Update #");
        System.out.println(" ");
        System.out.println("\t Update your animals Name, Food or Activity");
        System.out.println("\t What is your pets name?");
        System.out.println(" ");
        System.out.print("\t > ");
        String animalName = getUserString();

        System.out.println(" ");
        System.out.println("\t What do you want to update?");
        System.out.println(" ");
        System.out.println("\t [1] New Name");
        System.out.println("\t [2] New Food");
        System.out.println("\t [3] New Activity");
        System.out.println(" ");
        System.out.print("\t > ");
        int userInput = getUserInt();

        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getGuest() != null && animalName.equals(roomList.get(i).getGuest().getName())) {
                if (userInput == 1) {
                    System.out.println(" ");
                    System.out.println("\t What is " + animalName + "s new name?");
                    System.out.println(" ");
                    System.out.print("\t > ");
                    String newName = getUserString();
                    roomList.get(i).getGuest().setName(newName);
                    break;
                }
                if (userInput == 2) {
                    System.out.println(" ");
                    System.out.println("\t What is " + animalName + "s new favorite food?");
                    System.out.println(" ");
                    System.out.print("\t > ");
                    String newFood = getUserString();
                    roomList.get(i).getGuest().setFavoriteFood(newFood);
                    break;
                }
                if (userInput == 3) {
                    System.out.println(" ");
                    System.out.println("\t What is " + animalName + "s new favorite activity?");
                    System.out.println(" ");
                    System.out.print("\t > ");
                    String newActivity = getUserString();
                    roomList.get(i).getGuest().setFavoriteActivity(newActivity);
                    break;
                }else {
                    System.out.println("\t Sorry, " + animalName + " have not been booked here...");
                }
            }
        }
    }

    // Boknings info
    public void currentBookings() {

        System.out.println("___________________________________________________");
        System.out.println("\t          # Current Bookings #");
        System.out.println(" ");
        System.out.println("\t [1] List all bookings");
        System.out.println("\t [2] Specific booking info");
        System.out.println("\t [3] Filter booking by character  ");
        System.out.println("\t [4] Back to Main Menu");
        System.out.println(" ");
        System.out.print("\t > ");
        int userInput = getUserInt();

        switch (userInput) {
            case 1 -> listAllBookings();
            case 2 -> specificBooking();
            case 3 -> filteredBooking();
            case 4 -> mainMenu();
        }
    }

    // Listar alla bokningar med namn och rumsnummer
    public void listAllBookings() {
            System.out.println(" ");
        for (Room room : roomList) {
            if (room.getIsBooked()) {
                System.out.println("\t Name = " + room.getGuest().getName() + "\t Room = " + room.getRoomNr());
            }
        }
            System.out.println(" ");
            System.out.println("\t [1] Back to current bookings");
            System.out.println("\t [2] Back to Main Menu");
            System.out.println(" ");
            System.out.print("\t > ");
            int userInput = getUserInt();
            switch (userInput) {
                case 1 -> currentBookings();
                case 2 -> mainMenu();
            }
    }

    // Listar specifik bokning med all information
    public void specificBooking() {
            System.out.println(" ");
            System.out.println("\t Animal name");
            System.out.println(" ");
            System.out.print("\t > ");
            String animalName = getUserString();

        for (Room room : roomList) {
            if (room.getIsBooked() && animalName.equals(room.getGuest().getName())) {
                System.out.println(" ");
                System.out.println("________________________________________________________________________________");
                System.out.println("\t Animal Name = " + room.getGuest().getName() + ",\n\t Favorite Food = " + room.getGuest().getFavoriteFood() + ",\n\t Favorite Activity = " + room.getGuest().getFavoriteActivity()
                        + "\n\t Room = " + room.getRoomNr());

                System.out.println(" ");
                System.out.println("\t Room Description: ");
                room.describe();
                System.out.println("________________________________________________________________________________");
                System.out.println(" ");
            }else {
                System.out.println(" ");
                System.out.println("Sorry, " + animalName + " haven't been booked here...");
            }
        }
            System.out.println(" ");
            System.out.println("\t [1] Back to current bookings");
            System.out.println("\t [2] Search for another animal name");
            System.out.println("\t [3] Back to Main Menu");
            System.out.println(" ");
            System.out.print("\t > ");
            int userInput = getUserInt();
            switch (userInput) {
                case 1 -> currentBookings();
                case 2 -> specificBooking();
                case 3 -> mainMenu();
            }
    }

    // Listar filtrerade bokningar med all information
    public void filteredBooking() {
            System.out.println(" ");
            System.out.println("\t Search on character, for example [ A or a ]");
            System.out.println(" ");
            System.out.print("\t > ");
            String character = getUserString().toLowerCase();
            System.out.println(" ");

        for (Room room : roomList) {
            if (room.getIsBooked() && room.getGuest().getName().toLowerCase().contains(character)) {
                System.out.println("________________________________________________________________________________");
                System.out.println("\t Animal Name = " + room.getGuest().getName() + ",\n\t Favorite Food = " + room.getGuest().getFavoriteFood() + ",\n\t Favorite Activity = " + room.getGuest().getFavoriteActivity()
                        + "\n\t Room = " + room.getRoomNr());
                System.out.println(" ");
                System.out.println("\t Room Description: ");
                room.describe();
                System.out.println("________________________________________________________________________________");
                System.out.println(" ");

            }else {
                System.out.println("Sorry, we couldn't find any bookings info on [ " + character + "]");
            }
        }
            System.out.println("\t [1] Back to current bookings");
            System.out.println("\t [2] Search for another character");
            System.out.println("\t [3] Back to Main Menu");
            System.out.println(" ");
            System.out.print("\t > ");
            int userInput = getUserInt();
            switch (userInput) {
                case 1 -> currentBookings();
                case 2 -> filteredBooking();
                case 3 -> mainMenu();
            }
    }
}





