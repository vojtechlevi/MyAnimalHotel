public class Dog extends Animal {

    public Dog(String name, String favoriteFood, String favoriteActivity) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.favoriteActivity = favoriteActivity;
    }

    @Override
    public void sayHello() {
        System.out.println("\t " + name + " says: Woff Woff.");
    }
    
}

