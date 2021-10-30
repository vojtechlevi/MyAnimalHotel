import java.util.ArrayList;
import java.util.Scanner;

public class AnimalHotel {

    ArrayList<Room> animalRoom = new ArrayList<Room>();
    ArrayList<Animal> animalList = new ArrayList<Animal>();
    Scanner inputScanner = new Scanner(System.in);
    public boolean runProgram = true;

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
            System.out.println("\t [4] See available rooms");
            System.out.println("\t [5] See current bookings");
            System.out.println("\t [6] Back to start menu");
            System.out.println(" ");
            System.out.print("\t > ");
            int userInput = getUserInt();
            switch (userInput) {
                case 1 -> animalCheckIn();
                case 2 -> animalCheckOut();
                case 3 -> animalUpdate();
                case 4 -> availableRooms();
                case 5 -> currentBookings();
                case 6 -> startMenu();
                default -> System.out.println("\t Sorry, try again!");
            }
        }
    }

    public void animalCheckIn() {

        Animal newAnimal;

        System.out.println("___________________________________________________");
        System.out.println("\t          # Animal Check-in #");
        System.out.println(" ");
        System.out.println("\t Which kind of animal do you want a room for?");
        System.out.println(" ");
        System.out.print("\t > ");
        String userAnimal = getUserString();
        if (userAnimal.equals("Dog") || userAnimal.equals("dog") || userAnimal.equals("Cat") || userAnimal.equals("cat") || userAnimal.equals("Turtle") || userAnimal.equals("turtle")) {
            System.out.println("\t Great, We love " + userAnimal + "'s!");
            System.out.println(" ");

            //Lägg till sout för lediga rum???

        } else {
            System.out.println("\t Sorry, we cannot book a room for " + userAnimal + "'s...");
            mainMenu();
        }
        System.out.println("\t And what's the name of your " + userAnimal + "?");
        System.out.print("\t > ");
        String animalName = getUserString();
        System.out.println(" ");
        System.out.println("\t Cute name, we look forward to meet " + animalName + "!");
        System.out.println("\t but first we need to know a few more things,");
        System.out.println("\t what is " + animalName + "'s favorite food?");
        System.out.print("\t > ");
        String animalFood = getUserString();
        System.out.println(" ");
        System.out.println("\t We got plenty of " + animalFood + ", and are sure that " + animalName + " will enjoy the stay here!");
        System.out.println("\t One last thing! what is " + animalName + "'s favorite activity?");
        System.out.print("\t > ");
        String animalActivity = getUserString();
        System.out.println(" ");
        System.out.println("\t Good to know that " + animalName + " likes " + animalActivity);

        if (userAnimal.equals("Dog") || userAnimal.equals("dog")) {
            newAnimal = new Dog(animalName, animalFood, animalActivity);
            newAnimal.sayHello();
            animalList.add(newAnimal);

        }
        if (userAnimal.equals("Cat") || userAnimal.equals("cat")) {
            newAnimal = new Cat(animalName, animalFood, animalActivity);
            newAnimal.sayHello();
            animalList.add(newAnimal);

        }
        if (userAnimal.equals("Turtle") || userAnimal.equals("turtle")) {
            newAnimal = new Turtle(animalName, animalFood, animalActivity);
            newAnimal.sayHello();
            animalList.add(newAnimal);

        }

        System.out.println(" ");
        System.out.println("\t [1] Main Menu");
        System.out.println("\t [2] Check-in again");
        System.out.print("\t > ");
        int userInput = getUserInt();
        switch (userInput) {
            case 1 -> mainMenu();
            case 2 -> animalCheckIn();
        }

    }  // Lägg till rum

    public void animalCheckOut() {

        System.out.println("___________________________________________________");
        System.out.println("\t          # Animal Check-out #");
        System.out.println(" ");
        System.out.println("\t What is your pets name?");
        System.out.println(" ");
        System.out.print("\t > ");
        String animalName = getUserString();
        int count = 0;

        if(animalList.isEmpty()){
            System.out.println("\t Sorry, " + animalName + " haven't been booked here ");
        }

        for (int i = 0; i < animalList.size(); i++) {
            if (animalName.equals(animalList.get(i).getName())) {
                count = 1;
                if(count == 1) {
                    System.out.println(" ");
                    System.out.println("\t We are sure that " + animalName + " had a great time being here!");
                    System.out.println("\t Thanks you for booking at our Hotel!");
                    animalList.remove(i);
                    break;
                }else{
                    System.out.println("\t Sorry, " + animalName + " haven't been booked here ");
                }
            }
        }


    }

    public void animalUpdate() {

        System.out.println("___________________________________________________");
        System.out.println("\t          # Animal Update #");
        System.out.println(" ");
        System.out.println("\t Does your pet have a new favorite activity?");
        System.out.println("\t What is your pets name?");
        System.out.println(" ");
        System.out.print("\t > ");
        String animalName = getUserString();
        int count = 0;

        if(animalList.isEmpty()){
            System.out.println("\t Sorry, " + animalName + " haven't been booked here ");
        }

        for (int i = 0; i < animalList.size(); i++) {
            if (animalName.equals(animalList.get(i).getName())) {
                count ++;
                if(count == 1) {
                    System.out.println(" ");
                    System.out.println("\t What is " + animalName + "s new favorite activity?");
                    System.out.println(" ");
                    System.out.print("\t > ");
                    String newActivity = getUserString();
                    animalList.get(i).setFavoriteActivity(newActivity);
                }
            }else{
                System.out.println("\t Sorry, " + animalName + " have not been booked here...");
            }
        }
    }

    public void availableRooms() {

    }

    public void currentBookings() {

        System.out.println("___________________________________________________");
        System.out.println("\t          # Current Bookings #");
        System.out.println(" ");

        if(animalList.isEmpty()){
            System.out.println("\t    There's no bookings at the moment");
        }

        for (Animal animal : animalList) {
            System.out.println(animal);
        }

    }
}



