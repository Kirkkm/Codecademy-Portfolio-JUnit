import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Armor mjolnirArmor;
    private final String mjolnirDescription = "The MJOLNIR Powered Assault Armor/Mark VI was the third major version of the MJOLNIR Powered Assault Armor. The last mainline MJOLNIR GEN1 suit to be widely issued, the Mark VI was issued to the few surviving Spartan-II supersoldiers in October 2552, replacing the Mark V. Shortly after the end of the Human-Covenant War, it was replaced by the Mark VII and MJOLNIR [GEN2]. The Mark VI could still be requisitioned by Spartan-IV personnel as late as October 2558, albeit upgraded to function with the GEN2 suite. In early 2559, in the midst of the Created conflict, the Mark VI armor has been upgraded to the GEN3 platform.";

    private Weapon battleRifle;
    private Weapon plasmaRifle;
    private final String brDescription = "The BR55 Service Rifle is an infantry battle rifle in service within the armed forces of the United Nations Space Command. Among UNSC service personnel, the BR55 has accumulated a number of nicknames including the \"Monkey Wrench\", \"BR\", and the \"Big Boy\". It is notable for its powerful three-round burst fire and accurate 2× scope, making it more efficient at farther ranges than the MA5 series assault rifles.";
    private final String prDescription = "The Okarda'phaa-pattern Rifle (UNSC Type classification: Type-25 Directed Energy Rifle, T-25 DER), more commonly known as the plasma rifle or plasma gun, is a fully automatic rifle, formerly serving as a Covenant infantry weapon. The Type-25 DER was the primary weapon of the Covenant's officer corps, standard issue to Sangheili and Jiralhanae. However, lower-caste species within the Covenant who had attained significant rank within the Covenant military were also issued this weapon during operations. The Type-25 DER was one of the earliest and most frequently encountered Covenant plasma weapons. It occupies a role very similar to the human assault rifle.";

    private Food MRE;
    private final String mreDescription = "a self-contained, prepackaged meal designed for military and emergency use, providing a full day's caloric and nutritional requirements in a single, lightweight pouch";


    @BeforeEach
    void setUp() {
        mjolnirArmor = new Armor("MJOLNIR Armor", mjolnirDescription, 20000, 1);

        battleRifle = new Weapon("Battle Rifle", brDescription, 1500, 1);
        plasmaRifle = new Weapon("Plasma Rifle", prDescription, 1200, 1);

        MRE = new Food("MRE", mreDescription, new Stats(1000, 0,1000, 500), 3);
    }

    @Test
    void getName() {
        assertEquals("MJOLNIR Armor", mjolnirArmor.getName());

        assertEquals("Battle Rifle", battleRifle.getName());
        assertEquals("Plasma Rifle", plasmaRifle.getName());

        assertEquals("MRE", MRE.getName());
    }

    @Test
    void getDescription() {
        assertEquals(mjolnirDescription, mjolnirArmor.getDescription());

        assertEquals(brDescription, battleRifle.getDescription());
        assertEquals(prDescription, plasmaRifle.getDescription());

        assertEquals(mreDescription, MRE.getDescription());
    }

    @Test
    void getType() {
        assertEquals("Armor", mjolnirArmor.getType());

        assertEquals("Weapon", battleRifle.getType());
        assertEquals("Weapon", plasmaRifle.getType());

        assertEquals("Food", MRE.getType());
    }

    @Test
    void getQuantity() {
        assertEquals(3, MRE.getQuantity());
    }

    @Test
    void addItem() {
        MRE.addItem(1);
        assertEquals(4, MRE.getQuantity());

        assertThrowsExactly(IllegalArgumentException.class,() -> MRE.addItem(-1));
    }

    @Test
    void removeItem() {
        MRE.removeItem(2);
        assertEquals(1, MRE.getQuantity());

        assertThrowsExactly(IllegalArgumentException.class,() -> MRE.removeItem(-1));
    }

    @Test
    void testToString() {
        String expect = """
                Name: MJOLNIR Armor
                Description: The MJOLNIR Powered Assault Armor/Mark VI was the third major version of the MJOLNIR Powered Assault Armor. The last mainline MJOLNIR GEN1 suit to be widely issued, the Mark VI was issued to the few surviving Spartan-II supersoldiers in October 2552, replacing the Mark V. Shortly after the end of the Human-Covenant War, it was replaced by the Mark VII and MJOLNIR [GEN2]. The Mark VI could still be requisitioned by Spartan-IV personnel as late as October 2558, albeit upgraded to function with the GEN2 suite. In early 2559, in the midst of the Created conflict, the Mark VI armor has been upgraded to the GEN3 platform.
                Type: Armor""";
        assertEquals(expect, mjolnirArmor.toString());

        String expectedBr = """
                Name: Battle Rifle
                Description: The BR55 Service Rifle is an infantry battle rifle in service within the armed forces of the United Nations Space Command. Among UNSC service personnel, the BR55 has accumulated a number of nicknames including the "Monkey Wrench", "BR", and the "Big Boy". It is notable for its powerful three-round burst fire and accurate 2× scope, making it more efficient at farther ranges than the MA5 series assault rifles.
                Type: Weapon""";
        assertEquals(expectedBr, battleRifle.toString());

        String expectedPr = """
                Name: Plasma Rifle
                Description: The Okarda'phaa-pattern Rifle (UNSC Type classification: Type-25 Directed Energy Rifle, T-25 DER), more commonly known as the plasma rifle or plasma gun, is a fully automatic rifle, formerly serving as a Covenant infantry weapon. The Type-25 DER was the primary weapon of the Covenant's officer corps, standard issue to Sangheili and Jiralhanae. However, lower-caste species within the Covenant who had attained significant rank within the Covenant military were also issued this weapon during operations. The Type-25 DER was one of the earliest and most frequently encountered Covenant plasma weapons. It occupies a role very similar to the human assault rifle.
                Type: Weapon""";
        assertEquals(expectedPr, plasmaRifle.toString());
    }
}