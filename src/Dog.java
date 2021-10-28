public class Dog extends Animal {

    public Dog(String name, String favoriteFood, String favoriteActivity) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.favoriteActivity = favoriteActivity;
    }

    public void sayHello() {
        System.out.println("The dog says: Woff Woff.");
    }

}

