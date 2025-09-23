import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienTest {
    private Alien alienEntityTest;

    @BeforeEach
    void setUp() {
        alienEntityTest = new Alien("Arbiter", "Attacker");
    }

    @Test
    void mutate() {
        assertEquals(300, alienEntityTest.getStats().getHealth());
        assertEquals(300, alienEntityTest.getStats().getHealthPoints());
        assertEquals(1200, alienEntityTest.getStats().getBaseAttack());
        assertEquals(200, alienEntityTest.getStats().getDefensePoints());

        alienEntityTest.mutate();

        assertNotEquals(300, alienEntityTest.getStats().getHealth());
        assertNotEquals(300, alienEntityTest.getStats().getHealthPoints());
        assertNotEquals(1200, alienEntityTest.getStats().getBaseAttack());
        assertNotEquals(200, alienEntityTest.getStats().getDefensePoints());
    }

    @Test
    void regen() {
        assertEquals(300, alienEntityTest.getStats().getHealth());

        alienEntityTest.takeDamage(400);
        assertEquals(100, alienEntityTest.getStats().getHealth());

        alienEntityTest.regen();
        assertEquals(115, alienEntityTest.getStats().getHealth());
    }
}