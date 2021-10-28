public class Cat extends Animal {

    public Cat(String name, String favoriteFood, String favoriteActivity) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.favoriteActivity = favoriteActivity;
    }

    public void sayHello() {
        System.out.println("The cat says: Meow.");
    }
}
