import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    private Armor mjolnirArmor;
    private Human humanEntityTest;
    private Food MRE;
    private Stats statsTest;

    @BeforeEach
    void setUp() {
        String mjolnirDescription = "The MJOLNIR Powered Assault Armor/Mark VI was the third major version of the MJOLNIR Powered Assault Armor. The last mainline MJOLNIR GEN1 suit to be widely issued, the Mark VI was issued to the few surviving Spartan-II supersoldiers in October 2552, replacing the Mark V. Shortly after the end of the Human-Covenant War, it was replaced by the Mark VII and MJOLNIR [GEN2]. The Mark VI could still be requisitioned by Spartan-IV personnel as late as October 2558, albeit upgraded to function with the GEN2 suite. In early 2559, in the midst of the Created conflict, the Mark VI armor has been upgraded to the GEN3 platform.";
        mjolnirArmor = new Armor("MJOLNIR Armor", mjolnirDescription, 20000, 1);

        String mreDescription = "a self-contained, prepackaged meal designed for military and emergency use, providing a full day's caloric and nutritional requirements in a single, lightweight pouch";
        Stats mreStatsEffect = new Stats(500, 0, 200, 0);
        MRE = new Food("MRE", mreDescription, mreStatsEffect, 1);

        humanEntityTest = new Human("John", 1000, 1000, 500, 500);
    }

    @Test
    void equipArmor() {
        assertNull(humanEntityTest.getEquippedArmor());

        humanEntityTest.equipArmor(mjolnirArmor);
        Stats stats = humanEntityTest.getStats();
        assertEquals(20500, stats.getDefensePoints());

        assertNotNull(humanEntityTest.getEquippedArmor());
    }

    @Test
    void eatFood() {
        assertEquals(1000, humanEntityTest.getStats().getHealth());
        assertEquals(1000, humanEntityTest.getStats().getHealthPoints());
        assertEquals(500, humanEntityTest.getStats().getBaseAttack());
        assertEquals(500, humanEntityTest.getStats().getDefensePoints());

        humanEntityTest.eatFood(MRE);

        assertEquals(1000, humanEntityTest.getStats().getHealth());
        assertEquals(1000, humanEntityTest.getStats().getHealthPoints());
        assertEquals(700, humanEntityTest.getStats().getBaseAttack());
        assertEquals(500, humanEntityTest.getStats().getDefensePoints());
    }
}