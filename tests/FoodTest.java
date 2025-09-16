import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    private Food MRE;
    private Stats statsTest;

    @BeforeEach
    void setUp() {
        String mreDescription = "a self-contained, prepackaged meal designed for military and emergency use, providing a full day's caloric and nutritional requirements in a single, lightweight pouch";
        Stats mreStatsEffect = new Stats(500, 200, 0);
        MRE = new Food("MRE", mreDescription, mreStatsEffect);

        statsTest = new Stats(1000, 1000, 500);
    }

    @Test
    void eatFood() {
        Stats updatedStats = MRE.eatFood(statsTest);
        assertEquals(1500, updatedStats.getHealth());
        assertEquals(1200, updatedStats.getBaseAttack());
        assertEquals(500, updatedStats.getDefensePoints());
    }

    @Test
    void toStringTest() {
        String expected = """
                Name: MRE
                Description: a self-contained, prepackaged meal designed for military and emergency use, providing a full day's caloric and nutritional requirements in a single, lightweight pouch
                Type: Food
                
                Status Effect
                =========
                Health: 500
                Base Attack: 200
                Defense: 0""";
        assertEquals(expected, MRE.toString());
    }


}