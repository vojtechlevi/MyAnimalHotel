public class Animal {

    // Djur attribut av strängar, Namn, Favorit Mat och Favorit Aktivitet
    String name;
    String favoriteFood;
    String favoriteActivity;

    public Animal() {

    }

    // Getter och Setter metoder för inkapsling av data
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

    // Metod som overridas med hjälp av arv i Dog, Cat och Turtle klasserna
    public void sayHello() {
        System.out.println("\t The animals says hello!");
    }


}
