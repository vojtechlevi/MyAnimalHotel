public class Animal {

    String name;
    String favoriteFood;
    String favoriteActivity;

    public Animal() {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }
    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteActivity() {
        return favoriteActivity;
    }
    public void setFavoriteActivity(String favoriteActivity) {
        this.favoriteActivity = favoriteActivity;
    }

    public void sayHello() {
        System.out.println("\t The animals says hello!");
    }

    @Override
    public String toString() {
        return "\n Animal {" + "Name = '" + name + '\''  + '}' + " ";
    }

}
