import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbilityTest {

    private Ability brace;
    private Stats statsTest;

    @BeforeEach
    void setUp() {
        brace = new Ability("Brace", "Raise your defences to prepare for an attack", "Universal", new Stats(0, 0, 500));
        statsTest = new Stats(1000, 1000, 500);
    }

    @Test
    void getName() {
        assertEquals("Brace", brace.getName());
    }
    @Test
    void getDescription() {
        assertEquals("Raise your defences to prepare for an attack", brace.getDescription());
    }

    @Test
    void getType() {
        assertEquals("Universal", brace.getType());
    }

    @Test
    void useAbility() {
        Stats updatedStats = brace.useAbility(statsTest);
        assertEquals(1000, updatedStats.getHealth());
        assertEquals(1000, updatedStats.getBaseAttack());
        assertEquals(1000, updatedStats.getDefensePoints());
    }

    @Test
    void testToString() {
        String expect = """
                Name: Brace
                Description: Raise your defences to prepare for an attack
                Type: Universal
                
                Status Effect
                --------------
                Health: 0
                Base Attack: 0
                Defense: 500""";
        assertEquals(expect, brace.toString());
    }
}