import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsTest {

    private Stats testStats;

    @BeforeEach
    void setUp() {
        testStats = new Stats(1500, 1000, 1000);
    }

    @Test
    void getHealth() {
        assertEquals(1500, testStats.getHealth());
    }

    @Test
    void takeDamage() {
        testStats.takeDamage(500);
        assertEquals(1000, testStats.getHealth());
    }

    @Test
    void retoreHealth() {
        testStats.retoreHealth(1000);
        assertEquals(2500, testStats.getHealth());
    }

    @Test
    void getBaseAttack() {
        assertEquals(1000, testStats.getBaseAttack());
    }

    @Test
    void updateBaseAttack() {
        testStats.updateBaseAttack(500);
        assertEquals(1500, testStats.getBaseAttack());

        testStats.updateBaseAttack(-500);
        assertEquals(1000, testStats.getBaseAttack());
    }

    @Test
    void getDefensePoints() {
        assertEquals(1000, testStats.getDefensePoints());
    }

    @Test
    void updateDefensePoints() {
        testStats.updateDefensePoints(500);
        assertEquals(1500, testStats.getDefensePoints());

        testStats.updateDefensePoints(-500);
        assertEquals(1000, testStats.getDefensePoints());
    }

    @Test
    void toStringTest() {
        String expect = """
                Stats
                =========
                Health: 1500
                Base Attack: 1000
                Defense Points: 1000""";
        assertEquals(expect, testStats.toString());
    }
}