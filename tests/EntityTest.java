import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    private Human humanEntityTest;
    private Alien alienEntityTest;

    @BeforeEach
    void setUp() {
        humanEntityTest = new Human("Alex", 1000, 500, 500);
        alienEntityTest = new Alien("Hunter", "Attacker");
    }

    @Test
    void attack() {
        assertEquals(500, humanEntityTest.attack());
        assertEquals(1200, alienEntityTest.attack());
    }

    @Test
    void useAbility() {
    }

    @Test
    void learnAbility() {
    }

    @Test
    void getAbilities() {
    }

    @Test
    void equipWeapon() {
    }

    @Test
    void getEquipedWeapon() {
    }

    @Test
    void useItem() {
    }

    @Test
    void storeItem() {
    }

    @Test
    void getItems() {
    }

    @Test
    void testGetItems() {
    }
}