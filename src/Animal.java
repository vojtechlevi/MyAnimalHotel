public class Animal {

    String name;
    String favoriteFood;
    String favoriteActivity;

    public Animal() {

    }

    public void sayHello() {
        System.out.println("The animals says hello!");
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

    @Override
    public String toString() {
        return "Animal {" +
                "Name = '" + name + '\'' +
                ", Favorite Food = '" + favoriteFood + '\'' +
                ", Favorite Activity = '" + favoriteActivity + '\'' +
                '}';
    }
}
