import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {


    @Test
    void getName() {

        Animal TestAnimal = new Dog("Harry", "Ham", "Fetch");
        assertEquals("Harry", TestAnimal.getName());

    }

    @Test
    void getFavoriteFood() {
        Animal TestAnimal = new Dog("Harry", "Ham", "Fetch");
        assertEquals("Ham", TestAnimal.getFavoriteFood());

    }

    @Test
    void getFavoriteActivity() {
        Animal TestAnimal = new Dog("Harry", "Ham", "Fetch");
        assertEquals("Fetch", TestAnimal.getFavoriteActivity());
    }
}