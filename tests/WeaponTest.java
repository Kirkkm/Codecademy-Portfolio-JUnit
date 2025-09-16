import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    private Weapon battleRifle;
    private Weapon plasmaRifle;

    @BeforeEach
    void setUp() {
        String brDescription = "The BR55 Service Rifle is an infantry battle rifle in service within the armed forces of the United Nations Space Command. Among UNSC service personnel, the BR55 has accumulated a number of nicknames including the \"Monkey Wrench\", \"BR\", and the \"Big Boy\". It is notable for its powerful three-round burst fire and accurate 2× scope, making it more efficient at farther ranges than the MA5 series assault rifles.";
        battleRifle = new Weapon("Battle Rifle", brDescription, 1500);

        String prDescription = "The Okarda'phaa-pattern Rifle (UNSC Type classification: Type-25 Directed Energy Rifle, T-25 DER), more commonly known as the plasma rifle or plasma gun, is a fully automatic rifle, formerly serving as a Covenant infantry weapon. The Type-25 DER was the primary weapon of the Covenant's officer corps, standard issue to Sangheili and Jiralhanae. However, lower-caste species within the Covenant who had attained significant rank within the Covenant military were also issued this weapon during operations. The Type-25 DER was one of the earliest and most frequently encountered Covenant plasma weapons. It occupies a role very similar to the human assault rifle.";
        plasmaRifle = new Weapon("Plasma Rifle", prDescription, 1200);
    }

    @Test
    void getAttackPoints() {
        assertEquals(1500, battleRifle.getAttackPoints());
        assertEquals(1200, plasmaRifle.getAttackPoints());
    }
}