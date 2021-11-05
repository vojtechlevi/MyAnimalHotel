public class Cat extends Animal {

    public Cat(String name, String favoriteFood, String favoriteActivity) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.favoriteActivity = favoriteActivity;
    }

    @Override
    public void sayHello() {
        System.out.println("\t The cat says: Meow.");
    }

}
