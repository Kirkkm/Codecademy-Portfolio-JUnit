import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
    private Armor mjolnirArmor;

    @BeforeEach
    void setUp() {
        String mjolnirDescription = "The MJOLNIR Powered Assault Armor/Mark VI was the third major version of the MJOLNIR Powered Assault Armor. The last mainline MJOLNIR GEN1 suit to be widely issued, the Mark VI was issued to the few surviving Spartan-II supersoldiers in October 2552, replacing the Mark V. Shortly after the end of the Human-Covenant War, it was replaced by the Mark VII and MJOLNIR [GEN2]. The Mark VI could still be requisitioned by Spartan-IV personnel as late as October 2558, albeit upgraded to function with the GEN2 suite. In early 2559, in the midst of the Created conflict, the Mark VI armor has been upgraded to the GEN3 platform.";
        mjolnirArmor = new Armor("MJOLNIR Armor", mjolnirDescription, 20000, 1);
    }

    @Test
    void getDefensePoints() {
        assertEquals(20000, mjolnirArmor.getDefensePoints());
    }
}