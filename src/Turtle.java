public class Turtle extends Animal {

    public Turtle(String name, String favoriteFood, String favoriteActivity) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.favoriteActivity = favoriteActivity;
    }

    public void sayHello() {
        System.out.println("\t The turtle remains silent...");
    }
}
