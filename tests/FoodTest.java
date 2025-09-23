import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    private Food MRE;
    private Stats statsTest;

    @BeforeEach
    void setUp() {
        String mreDescription = "a self-contained, prepackaged meal designed for military and emergency use, providing a full day's caloric and nutritional requirements in a single, lightweight pouch";
        Stats mreStatsEffect = new Stats(500, 0, 200, 0);
        MRE = new Food("MRE", mreDescription, mreStatsEffect, 1);

        statsTest = new Stats(1000, 1000, 0, 500);
    }

    @Test
    void eatFood() {
        Stats updatedStats = MRE.eatFood(statsTest);
        assertEquals(1000, updatedStats.getHealth());
        assertEquals(1000, updatedStats.getHealthPoints());
        assertEquals(200, updatedStats.getBaseAttack());
        assertEquals(500, updatedStats.getDefensePoints());

        Stats noUpdatedStats = MRE.eatFood(statsTest);

        assertEquals(1000, noUpdatedStats.getHealth());
        assertEquals(1000, noUpdatedStats.getHealthPoints());
        assertEquals(200, noUpdatedStats.getBaseAttack());
        assertEquals(500, noUpdatedStats.getDefensePoints());
    }

    @Test
    void toStringTest() {
        String expected = """
                Name: MRE
                Description: a self-contained, prepackaged meal designed for military and emergency use, providing a full day's caloric and nutritional requirements in a single, lightweight pouch
                Type: Food
                
                Status Effect
                --------------
                Health: 500
                Base Attack: 200
                Defense: 0""";
        assertEquals(expected, MRE.toString());
    }


}