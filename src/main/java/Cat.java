public class Cat extends Animal {

    // Denna klass ärver från klassen Animal

    // Konstruktor som tar emot tre argument och sätter värdena till det specifika djuret
    public Cat(String name, String favoriteFood, String favoriteActivity) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.favoriteActivity = favoriteActivity;
    }

    // Overridar Animal klassens metod sayHello()
    @Override
    public void sayHello() {
        System.out.println("\t The cat says: Meow.");
    }

}
