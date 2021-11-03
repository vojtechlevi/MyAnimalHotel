import java.util.ArrayList;
import java.util.Scanner;

public class AnimalHotel {

    ArrayList<Room> roomList = new ArrayList<Room>();
    ArrayList<Animal> animalList = new ArrayList<Animal>();
    Scanner inputScanner = new Scanner(System.in);
    public boolean runProgram = true;
    Room mainRoom = new Room();

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
                System.out.println("Felaktigt menyval");
            }
        }
        return myInt;
    }

    public void startMenu() {

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
            System.out.println("\t [5] Back to start menu");
            System.out.println(" ");
            System.out.print("\t > ");
            int userInput = getUserInt();
            switch (userInput) {
                case 1 -> animalCheckIn();
                case 2 -> animalCheckOut();
                case 3 -> animalUpdate();
                case 4 -> currentBookings();
                case 5 -> startMenu();
                default -> System.out.println("\t Sorry, try again!");
            }
        }
    }

    public void animalCheckIn() {

        Animal newAnimal;
        Room mainRoom = new Room();
        Room newRoom;


        System.out.println("___________________________________________________");
        System.out.println("\t          # Animal Check-in #");
        System.out.println(" ");
        System.out.println("\t Room Description: ");
        mainRoom.describe();
        System.out.println(" ");
        System.out.println("\t Which animal do you want to book a room for?");
        System.out.println(" ");
        System.out.print("\t > ");
        String userAnimal = getUserString();
        if (userAnimal.equals("Dog") || userAnimal.equals("dog") || userAnimal.equals("Cat") || userAnimal.equals("cat") || userAnimal.equals("Turtle") || userAnimal.equals("turtle")) {
            System.out.println("\t Great, We love " + userAnimal + "'s!");
            System.out.println(" ");

        } else {
            System.out.println("\t Sorry, we cannot book a room for " + userAnimal + "'s...");
            System.out.println(" ");
            mainMenu();
        }
        System.out.println("\t And what's the name of your " + userAnimal + "?");
        System.out.println(" ");
        System.out.print("\t > ");
        String animalName = getUserString();
        System.out.println("\t Cute name, we look forward to meet " + animalName + "!");
        System.out.println("\t but first we need to know a few more things,");
        System.out.println(" ");
        System.out.println("\t What is " + animalName + "'s favorite food?");
        System.out.println(" ");
        System.out.print("\t > ");
        String animalFood = getUserString();
        System.out.println("\t We got plenty of " + animalFood + ", and are sure that " + animalName + " will enjoy the stay here!");
        System.out.println(" ");
        System.out.println("\t One last thing! what is " + animalName + "'s favorite activity?");
        System.out.print("\t > ");
        String animalActivity = getUserString();
        System.out.println(" ");
        System.out.println("\t Good to know that " + animalName + " likes " + animalActivity);

        if (userAnimal.equals("Dog") || userAnimal.equals("dog")) {
            newAnimal = new Dog(animalName, animalFood, animalActivity);
            animalList.add(newAnimal);
            newRoom = new DogRoom(1, 1);
            roomList.add(newRoom);

            System.out.println("\t Since you have a dog we will book a dog room for you!");
            newRoom.describe();
            System.out.println(" ");
            newAnimal.sayHello();
        }
        if (userAnimal.equals("Cat") || userAnimal.equals("cat")) {
            newAnimal = new Cat(animalName, animalFood, animalActivity);
            animalList.add(newAnimal);
            newRoom = new CatRoom(2);
            roomList.add(newRoom);

            System.out.println("\t Since you have a cat we will book a cat room for you!");
            newRoom.describe();
            System.out.println(" ");
            newAnimal.sayHello();
        }
        if (userAnimal.equals("Turtle") || userAnimal.equals("turtle")) {
            newAnimal = new Turtle(animalName, animalFood, animalActivity);
            animalList.add(newAnimal);
            newRoom = new TurtleRoom(3);
            roomList.add(newRoom);

            System.out.println("\t Since you have a turtle we will book a turtle room for you!");
            newRoom.describe();
            System.out.println(" ");
            newAnimal.sayHello();
        }

        System.out.println(" ");
        System.out.println("\t [1] Back to Main Menu");
        System.out.println("\t [2] Check-in another animal");
        System.out.print("\t > ");
        int userInput = getUserInt();
        switch (userInput) {
            case 1 -> mainMenu();
            case 2 -> animalCheckIn();
        }

    }

    public void animalCheckOut() {

        System.out.println("___________________________________________________");
        System.out.println("\t          # Animal Check-out #");
        System.out.println(" ");
        System.out.println("\t What is your pets name?");
        System.out.println(" ");
        System.out.print("\t > ");
        String animalName = getUserString();
        int count = 0;

        if (animalList.isEmpty()) {
            System.out.println("\t Sorry, " + animalName + " haven't been booked here ");
        }

        for (int i = 0; i < animalList.size(); i++) {
            if (animalName.equals(animalList.get(i).getName())) {
                count++;
                if (count == 1) {
                    System.out.println(" ");
                    System.out.println("\t We are sure that " + animalName + " had a great time being here!");
                    System.out.println("\t Thanks you for booking at our Hotel!");
                    animalList.remove(i);
                    roomList.remove(i);
                    break;
                }
            }else {
                System.out.println("\t Sorry, " + animalName + " haven't been booked here ");
            }
        }
    }

    public void animalUpdate() {

        System.out.println("___________________________________________________");
        System.out.println("\t          # Animal Update #");
        System.out.println(" ");
        System.out.println("\t Update your animals favorite activity");
        System.out.println("\t What is your pets name?");
        System.out.println(" ");
        System.out.print("\t > ");
        String animalName = getUserString();
        int count = 0;

        if (animalList.isEmpty()) {
            System.out.println("\t Sorry, " + animalName + " haven't been booked here ");
        }

        for (Animal animal : animalList) {
            if (animalName.equals(animal.getName())) {
                count++;
                if (count == 1) {
                    System.out.println(" ");
                    System.out.println("\t What is " + animalName + "s new favorite activity?");
                    System.out.println(" ");
                    System.out.print("\t > ");
                    String newActivity = getUserString();
                    animal.setFavoriteActivity(newActivity);
                }
            } else {
                System.out.println("\t Sorry, " + animalName + " have not been booked here...");
            }
        }
    }

    // Booking Info
    public void currentBookings() {

        System.out.println("___________________________________________________");
        System.out.println("\t          # Current Bookings #");
        System.out.println(" ");
        System.out.println("\t [1] List all bookings");
        System.out.println("\t [2] Specific booking info");
        System.out.println("\t [3] Filter booking by character  ");
        System.out.println(" ");
        System.out.print("\t > ");
        int userInput = getUserInt();

        switch (userInput) {
            case 1 -> listAllBookings();
            case 2 -> specificBooking();
            case 3 -> filteredBooking();
        }
    }
    public void listAllBookings() {
        if (animalList.isEmpty()) {
            System.out.println("\t There's no bookings at the moment");
        }else {
            for (int i = 0; i < animalList.size(); i++){
                System.out.println("Name = " + animalList.get(i).getName() + " Room = " + roomList.get(i).getRoomNr());
            }
        }

    }
    public void specificBooking() {
        if (animalList.isEmpty()) {
            System.out.println("\t There's no bookings at the moment");
        }else {
            System.out.println("\t Animal name");
            System.out.print("\t > ");
            String animalName = getUserString();

            for (int i = 0; i < animalList.size(); i++) {
                if (animalName.equals(animalList.get(i).getName())) {


                    System.out.println("\t Animal Name = " + animalList.get(i).getName() + ", Favorite Food = " + animalList.get(i).getFavoriteFood() + ", Favorite Activity = " + animalList.get(i).getFavoriteActivity()
                            + "\n\t Room = " + roomList.get(i).getRoomNr());

                }
            }
        }
    }
    public void filteredBooking() {
        if (animalList.isEmpty()) {
            System.out.println("\t There's no bookings at the moment");
        }else {

            System.out.println("\t Search on character, for example [ A ]");
            System.out.println("> ");
            String character = getUserString().toLowerCase();

            for (int i = 0; i < animalList.size(); i++) {
                if (animalList.get(i).getName().toLowerCase().contains(character)) {
                    System.out.println(animalList.get(i));
                    System.out.println(roomList.get(i));

                }
            }
        }
    }
}




