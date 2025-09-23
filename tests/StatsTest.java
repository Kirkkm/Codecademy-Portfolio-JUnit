import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsTest {

    private Stats testStats;

    @BeforeEach
    void setUp() {
        testStats = new Stats(1000, 1000, 1000, 1000);
    }

    @Test
    void healthMethods() {
        assertEquals(1000, testStats.getHealth());

        assertEquals(1000, testStats.getHealthPoints());

        testStats.increaseHealthPoints(500);
        assertEquals(1500, testStats.getHealthPoints());

        testStats.takeDamage(500);
        assertEquals(500, testStats.getHealth());

        testStats.retoreHealth(1000);
        assertEquals(1500, testStats.getHealth());

        testStats.takeDamage(1000);
        testStats.retoreHealth(500);
        assertEquals(1000, testStats.getHealth());

        testStats.takeDamage(2000);
        assertEquals(0, testStats.getHealth());

        testStats.retoreHealth(500);
        assertEquals(0, testStats.getHealth());
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
                Health: 1000/1000
                Base Attack: 1000
                Defense Points: 1000""";
        assertEquals(expect, testStats.toString());
    }
}