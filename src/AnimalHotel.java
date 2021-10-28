import java.util.Scanner;

public class AnimalHotel {

    Dog dog;
    Cat cat;
    Turtle turtle;
    Room room = new Room();
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

        while(runProgram) {
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
            }
        }
    }

    public void mainMenu() {

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
        }
    }

    public void animalCheckIn() {

        System.out.println("___________________________________________________");
        System.out.println("\t          # Animal Check-in #");
        System.out.println(" ");
        System.out.println("\t Which kind of animal do you want a room for?");
        System.out.println(" ");
        System.out.print("\t > ");
        String userAnimal = getUserString();
        if(userAnimal.equals("Dog") || userAnimal.equals("dog")|| userAnimal.equals("Cat") || userAnimal.equals("cat") || userAnimal.equals("Turtle") || userAnimal.equals("turtle")){
            System.out.println("\t Great, We love " + userAnimal + "'s!");
            System.out.println(" ");

            //Lägg till sout för lediga rum???
        }else{
            System.out.println("\t Sorry, we cannot book a room for " + userAnimal + "'s...");
            animalCheckIn();
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
        System.out.println("Good to know that " + animalName + " likes " + animalActivity);
        System.out.println(" ");
        System.out.println("Checking available rooms...");

        if(userAnimal.equals("Dog") || userAnimal.equals("dog")){
           dog = new Dog(animalName, animalFood, animalActivity);
           dog.sayHello();
        }
        if(userAnimal.equals("Cat") || userAnimal.equals("cat")){
           cat = new Cat(animalName, animalFood, animalActivity);
           cat.sayHello();

        }
        if(userAnimal.equals("Turtle") || userAnimal.equals("turtle")){
           turtle = new Turtle(animalName, animalFood, animalActivity);
           turtle.sayHello();
        }


    }

    public void animalCheckOut() {

    }

    public void animalUpdate() {

    }

    public void availableRooms() {

    }

    public void currentBookings() {

    }
}



