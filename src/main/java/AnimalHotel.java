import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalHotel {

    ArrayList<Room> roomList; // Arraylist som ska lagra objekt av klassen Room
    Scanner inputScanner = new Scanner(System.in); // Scanner som lagrar inmatning från användaren
    public boolean runProgram = true;

    // Skapar en fil och tillfälliga variabler av Animal & Room som används i writeToFile() och loadFromFile()
    File file = new File("Kvitto.txt");
    Animal currentAnimalObj;
    Room currentRoomObj;


    // Två metoder som hämtar inmatning utav strängar och siffror
    public String getUserString() {

        return inputScanner.nextLine();
    }
    public int getUserInt() {
        int myInt;
        while (true) {
            try {
                myInt = Integer.parseInt(inputScanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("\t Sorry, try again!");
                System.out.println(" ");
                System.out.print("\t > ");
            }
        }
        return myInt;
    }

    // Två metoder för att kunna skriva till och ladda från filer
    public void writeToFile() throws IOException{


        // Frågar om användaren vill spara bokningar till en fil
        System.out.println("\t Would you like to save your booking?");
        System.out.println(" ");
        System.out.println("\t [1] Yes");
        System.out.println("\t [2] No, continue");
        System.out.println(" ");
        System.out.print("\t > ");
        int userInput = getUserInt();

        // Objekt av klassen Filewriter skapas och loopar igenom rumlistan om det finns någon bokning gjord
        // Skriver in all information om bokningen med String text och writer.write(text)
        // Om något problem uppstår fångas den av Catchen
        FileWriter writer = new FileWriter(file);
        if (userInput == 1) {

            try {
                for (int i = 0; i < roomList.size(); i++) {
                    if (roomList.get(i).getIsBooked()) {
                        String text = (roomList.get(i).getGuest().getClass() + "," + roomList.get(i).getGuest().getName() + "," + roomList.get(i).getGuest().getFavoriteFood() + "," + roomList.get(i).getGuest().getFavoriteActivity() + ","
                                + roomList.get(i).getRoomNr() + "," + roomList.get(i).getRoomName() + "," + roomList.get(i).getIsBooked() + "\n");
                        writer.write(text);

                    }
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("\t An error occurred.");
                e.printStackTrace();
            }
        }
    }
    public void loadFromFile(String file)throws IOException{

        // Skapar nya objekt av klasserna File och Scanner
        File file1 = new File(file);
        Scanner fileReader = new Scanner(file1);


        // Om filens längd är större än 1
        if(file1.length() > 1){

            // Och så länge det finns något att läsa från filen
            while(fileReader.hasNextLine()){

                // En String som läser rader i filen
                // En Array som sparar specifik information i separata index och splittar med ett komma
                String line = fileReader.nextLine();
                String[] attributes = line.split(",");

                // Sätter de olika värdena i separata index
                String animalClass = attributes[0];
                String animalName = attributes[1];
                String animalFood = attributes[2];
                String animalActivity = attributes[3];
                int roomNr = Integer.parseInt(attributes[4]); //
                String roomName = attributes[5];
                boolean roomBooked = Boolean.parseBoolean(attributes[6]);


                // Om något i filen finns så skapas ett objekt av det djuret med dem attributen som man sparat tidigare
                if(animalClass.equals("class Dog")){
                    currentAnimalObj = new Dog(animalName,animalFood,animalActivity);
                }
                if(animalClass.equals("class Cat")){
                    currentAnimalObj = new Cat(animalName,animalFood,animalActivity);
                }
                if(animalClass.equals("class Turtle")){
                    currentAnimalObj = new Turtle(animalName,animalFood,animalActivity);
                }

                // Om något specifikt rum finns lagrat i filen så skapas ett nytt objekt av det rummet och djuret sätts som gäst
                if(roomName.equals("Dog room")){
                    currentRoomObj = new DogRoom(roomNr,roomBooked,roomName);
                    currentRoomObj.setGuest(currentAnimalObj);
                }
                if(roomName.equals("Cat room")){
                    currentRoomObj = new CatRoom(roomNr,roomBooked,roomName);
                    currentRoomObj.setGuest(currentAnimalObj);
                }
                if(roomName.equals("Turtle room")) {
                    currentRoomObj = new TurtleRoom(roomNr, roomBooked, roomName);
                    currentRoomObj.setGuest(currentAnimalObj);
                }

                // Loopar igenom rumslistan och kollar om rumslistans rumsnummer är lika med det tillfälliga rummet
                // Skriver över det rummet med den tillfälliga gästen
                // Och sätter att rummet är bokat
                for(int i = 0; i < roomList.size(); i++){
                    if(roomList.get(i).getRoomNr() == currentRoomObj.getRoomNr()){
                        roomList.get(i).setGuest(currentAnimalObj);
                        roomList.get(i).setIsBooked(true);
                    }
                }
            }
        }
    }


    // Start Meny
    public void startMenu() throws IOException {

        initRooms(); // metod som skapar objekt av olika rum

        if(file.exists()){
            System.out.println("\t There's a file saved with previous bookings");
            System.out.println("\t Would you load that file?");
            System.out.println(" ");
            System.out.println("\t [1] Load from file");
            System.out.println("\t [2] No, continue");
            System.out.println(" ");
            System.out.print("\t >");
            int userInput = getUserInt();
            if(userInput == 1) {
                System.out.println(" ");
                System.out.println("\t Loading file...");
                loadFromFile("Kvitto.txt");
                System.out.println("\t Loading finished.");
            }
        }


        // Meny med olika val som styrs med en switch-sats
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
                case 2 -> {
                    runProgram = false;
                    writeToFile();
                }
                default -> System.out.println("\t Sorry, try again!");
            }
        }
    }

    // Skapar rum
    public void initRooms() {

        // Skapar olika rum och lagrar i arraylistan (roomList)
        roomList = new ArrayList<>();
        Room DogRoom1 = new DogRoom(1, false, "Dog room");
        roomList.add(DogRoom1);

        Room CatRoom1 = new CatRoom(2, false, "Cat room");
        roomList.add(CatRoom1);

        Room TurtleRoom1 = new TurtleRoom(3, false, "Turtle room");
        roomList.add(TurtleRoom1);
    }

    // Huvud Meny
    public void mainMenu() throws IOException {

        // Meny med olika val som styrs av en switch-sats
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
                case 5 -> {
                    runProgram = false;
                    writeToFile();
                }
                default -> System.out.println("\t Sorry, try again!");
            }
        }
    }

    // Djur incheckning
    public void animalCheckIn() throws IOException {

        Room mainRoom = new Room();
        Animal newAnimal = new Animal();

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

        //Skriver ut lediga rum med en for-loop som går igenom roomList
        System.out.println(" ");
        System.out.println("\t Room List for available rooms");
        System.out.println("\t _______________________________________________");
        for (int i = 0; i < roomList.size(); i++) {
            if (!roomList.get(i).getIsBooked()) {
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
        if (userInput == 1) {

            if (roomList.get(0).getIsBooked()) {
                System.out.println(" ");
                System.out.println("\t This room is already booked");
            } else {
                roomList.get(0).setGuest(newAnimal);
                roomList.get(0).setIsBooked(true);
                System.out.println(" ");
                System.out.println("\t Room Description:");
                roomList.get(0).describe();
                System.out.println(" ");
                newAnimal.sayHello();
            }
        }
        if (userInput == 2) {

            roomList.get(1).setGuest(newAnimal);
            roomList.get(1).setIsBooked(true);
            System.out.println(" ");
            System.out.println("\t Room Description:");
            roomList.get(1).describe();
            System.out.println(" ");
            newAnimal.sayHello();
        }
        if (userInput == 3) {

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
    public void animalCheckOut() throws IOException {

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
        int count = 0;
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getGuest() != null && animalName.equals(roomList.get(i).getGuest().getName())) {
                System.out.println(" ");
                System.out.println("\t We are sure that " + animalName + " had a great time being here!");
                System.out.println("\t Thanks you for booking at our Hotel!");
                roomList.get(i).setGuest(null);
                roomList.get(i).setIsBooked(false);
                break;
            }
            if(roomList.get(i).getGuest() != null && !animalName.equals(roomList.get(i).getGuest().getName())) {
                count++;
            }
        }
        if(count == 1 || count == 2 || count == 3) {
            System.out.println("\t Sorry, " + animalName + " haven't been booked here ");
        }
    }

    // Djur uppdatering
    public void animalUpdate() throws IOException {

        //Meny och olika val om användarens djur har nytt namn, favoritmat, eller ny favoritaktivitet
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

        //Kollar så att det namnet användaren skrivit in finns inbokat och skriver sedan ut beroende på vilket val
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
                } else {
                    System.out.println("\t Sorry, " + animalName + " have not been booked here...");
                }
            }
        }
    }

    // Meny för boknings info
    public void currentBookings() throws IOException {

        // Meny som styrs med en switch-sats beroende på val användaren matar in
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
    public void listAllBookings() throws IOException {

        //Loopar igenom alla rum i rumslistan och skriver ut namnen på djuren samt vilket rum dem är inbokade på
        System.out.println(" ");
        for (Room room : roomList) {
            if (room.getIsBooked()) {
                System.out.printf("\t Name = %-8s\t Room = %-16d \n", room.getGuest().getName(), room.getRoomNr());
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
    public void specificBooking() throws IOException {


        System.out.println(" ");
        System.out.println("\t Animal name");
        System.out.println(" ");
        System.out.print("\t > ");
        String animalName = getUserString();
        int count = 0;

        //Loopar igenom alla rum i rumslistan och skriver ut all information om bokningen för det djuret.
        for (Room room : roomList) {
            if (room.getIsBooked() && animalName.equals(room.getGuest().getName())) {
                count++;
                System.out.println(" ");
                System.out.println("________________________________________________________________________________");
                System.out.println("\t Animal Name = " + room.getGuest().getName() + ",\n\t Favorite Food = " + room.getGuest().getFavoriteFood() + ",\n\t Favorite Activity = " + room.getGuest().getFavoriteActivity()
                        + "\n\t Room = " + room.getRoomNr());

                System.out.println(" ");
                System.out.println("\t Room Description: ");
                room.describe();
                System.out.println("________________________________________________________________________________");
                System.out.println(" ");
                break;

            }
        }
        if (count == 0) {
            System.out.println("\t Sorry, we couldn't find any bookings info on " + animalName);
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
    public void filteredBooking() throws IOException {

        System.out.println(" ");
        System.out.println("\t Search on character, for example [ A or a ]");
        System.out.println(" ");
        System.out.print("\t > ");
        String character = getUserString().toLowerCase();
        int count = 0;

        // Låter användaren söka efter en eller flera bokstäver och skriver ut all information om bokningen för de djur med sökta bokstäver i deras namn.
        for (Room room : roomList) {
            if (room.getIsBooked() && room.getGuest().getName().toLowerCase().contains(character)) {
                count++;
                System.out.println(" ");
                System.out.println("________________________________________________________________________________");
                System.out.println("\t Animal Name = " + room.getGuest().getName() + ",\n\t Favorite Food = " + room.getGuest().getFavoriteFood() + ",\n\t Favorite Activity = " + room.getGuest().getFavoriteActivity()
                        + "\n\t Room = " + room.getRoomNr());
                System.out.println(" ");
                System.out.println("\t Room Description: ");
                room.describe();
                System.out.println("________________________________________________________________________________");
                System.out.println(" ");

            }
        }
        if (count == 0) {
            System.out.println("\t Sorry, we couldn't find any bookings info on [ " + character + " ]");
            System.out.println(" ");
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





