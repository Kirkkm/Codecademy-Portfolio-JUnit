import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AlienTest {
    private Alien alienEntityTest;

    private Food alienMRE;
    private Weapon plasmaRifle;
    private Armor mjolnirArmor;

    @BeforeEach
    void setUp() {
        alienEntityTest = new Alien("Arbiter", "Attacker");

        String prDescription = "The Okarda'phaa-pattern Rifle (UNSC Type classification: Type-25 Directed Energy Rifle, T-25 DER), more commonly known as the plasma rifle or plasma gun, is a fully automatic rifle, formerly serving as a Covenant infantry weapon. The Type-25 DER was the primary weapon of the Covenant's officer corps, standard issue to Sangheili and Jiralhanae. However, lower-caste species within the Covenant who had attained significant rank within the Covenant military were also issued this weapon during operations. The Type-25 DER was one of the earliest and most frequently encountered Covenant plasma weapons. It occupies a role very similar to the human assault rifle.";
        plasmaRifle = new Weapon("Plasma Rifle", prDescription, 1600, 1);

        String mjolnirDescription = "The MJOLNIR Powered Assault Armor/Mark VI was the third major version of the MJOLNIR Powered Assault Armor. The last mainline MJOLNIR GEN1 suit to be widely issued, the Mark VI was issued to the few surviving Spartan-II supersoldiers in October 2552, replacing the Mark V. Shortly after the end of the Human-Covenant War, it was replaced by the Mark VII and MJOLNIR [GEN2]. The Mark VI could still be requisitioned by Spartan-IV personnel as late as October 2558, albeit upgraded to function with the GEN2 suite. In early 2559, in the midst of the Created conflict, the Mark VI armor has been upgraded to the GEN3 platform.";
        mjolnirArmor = new Armor("MJOLNIR Armor", mjolnirDescription, 20000, 1);

        String mreDescription = "a self-contained, prepackaged meal designed for military and emergency use, providing a full day's caloric and nutritional requirements in a single, lightweight pouch";
        Stats mreStatsEffect = new Stats(500,0, 200, 0);
        alienMRE = new Food("MRE", mreDescription, mreStatsEffect, 1);
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

    @Test
    void itemOverrideMethods() {

        assertThrowsExactly(IllegalArgumentException.class, () -> alienEntityTest.useItem(plasmaRifle));
        assertThrowsExactly(IllegalArgumentException.class, () -> alienEntityTest.useItem(mjolnirArmor));
        assertThrowsExactly(IllegalArgumentException.class, () -> alienEntityTest.useItem(alienMRE));
        assertThrowsExactly(IllegalArgumentException.class, () -> alienEntityTest.useItem(new Item("test", "this is a test", "Item", 1) {
        }));
        assertThrowsExactly(IllegalArgumentException.class, () -> alienEntityTest.useItem(null));
    }
}