import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentTest {

    private Environment environmentTest;
    private Human humanEntityTest;
    private Alien alienEntityTest;

    @BeforeEach
    void setUp() {
        environmentTest = new Environment(3, 3, 1);
    }

    @Test
    void addToPlayersParty() {
        assertEquals(0, environmentTest.getPlayersPartySize());

        environmentTest.addToPlayersParty(humanEntityTest);
        assertEquals(1, environmentTest.getPlayersPartySize());

        environmentTest.addToPlayersParty(humanEntityTest);
        assertEquals(2, environmentTest.getPlayersPartySize());

        environmentTest.addToPlayersParty(alienEntityTest);
        assertEquals(3, environmentTest.getPlayersPartySize());

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> environmentTest.addToPlayersParty(alienEntityTest));
    }

    @Test
    void addToEnemiesParty() {
        assertEquals(0, environmentTest.getEnemiesPartySize());

        environmentTest.addToEnemiesParty(alienEntityTest);
        assertEquals(1, environmentTest.getEnemiesPartySize());

        environmentTest.addToEnemiesParty(alienEntityTest);
        assertEquals(2, environmentTest.getEnemiesPartySize());

        environmentTest.addToEnemiesParty(alienEntityTest);
        assertEquals(3, environmentTest.getEnemiesPartySize());

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> environmentTest.addToEnemiesParty(alienEntityTest));
    }



}