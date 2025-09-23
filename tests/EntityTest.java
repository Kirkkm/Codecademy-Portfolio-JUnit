import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {
    private Weapon battleRifle;
    private Weapon plasmaRifle;

    private String mreDescription;
    private Stats mreStatsEffect;
    private Food humanMRE;
    private Food alienMRE;

    private Ability brace;

    private Human humanEntityTest;
    private Alien alienEntityTest;


    @BeforeEach
    void setUp() {

        String brDescription = "The BR55 Service Rifle is an infantry battle rifle in service within the armed forces of the United Nations Space Command. Among UNSC service personnel, the BR55 has accumulated a number of nicknames including the \"Monkey Wrench\", \"BR\", and the \"Big Boy\". It is notable for its powerful three-round burst fire and accurate 2× scope, making it more efficient at farther ranges than the MA5 series assault rifles.";
        battleRifle = new Weapon("Battle Rifle", brDescription, 1500, 1);

        String prDescription = "The Okarda'phaa-pattern Rifle (UNSC Type classification: Type-25 Directed Energy Rifle, T-25 DER), more commonly known as the plasma rifle or plasma gun, is a fully automatic rifle, formerly serving as a Covenant infantry weapon. The Type-25 DER was the primary weapon of the Covenant's officer corps, standard issue to Sangheili and Jiralhanae. However, lower-caste species within the Covenant who had attained significant rank within the Covenant military were also issued this weapon during operations. The Type-25 DER was one of the earliest and most frequently encountered Covenant plasma weapons. It occupies a role very similar to the human assault rifle.";
        plasmaRifle = new Weapon("Plasma Rifle", prDescription, 1600, 1);

        mreDescription = "a self-contained, prepackaged meal designed for military and emergency use, providing a full day's caloric and nutritional requirements in a single, lightweight pouch";
        mreStatsEffect = new Stats(500,0, 200, 0);
        humanMRE = new Food("MRE", mreDescription, mreStatsEffect, 1);
        alienMRE = new Food("MRE", mreDescription, mreStatsEffect, 1);

        brace = new Ability("Brace", "Raise your defences to prepare for an attack", "Universal", new Stats(0, 0, 0, 500));

        humanEntityTest = new Human("John", 1000, 1000,500, 500);
        alienEntityTest = new Alien("Arbiter", "Attacker");
    }

    @Test
    void testSetUp() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Human("Bob", 1500, 1000, 0, 0 ));
        assertThrowsExactly(IllegalArgumentException.class, () -> new Human("Bob", 0, 1000, 0, 0 ));
        assertThrowsExactly(IllegalArgumentException.class, () -> new Human("Bob", 1500, 0, 0, 0 ));
        assertDoesNotThrow(() -> new Human("Bob", 1000, 1500, 1000, 1000 ));

        assertDoesNotThrow(() -> new Alien("CKJECT", "Base"));
        assertDoesNotThrow(() -> new Alien("CKJECT", "Tank"));
        assertDoesNotThrow(() -> new Alien("CKJECT", "Attacker"));
    }

    @Test
    void getName() {
        assertEquals("John", humanEntityTest.getName());
        assertEquals("Arbiter", alienEntityTest.getName());
    }

    @Test
    void getStats(){
        assertEquals(1000, humanEntityTest.getStats().getHealth());
        assertEquals(500, humanEntityTest.getStats().getBaseAttack());
        assertEquals(500, humanEntityTest.getStats().getDefensePoints());

        assertEquals(300, alienEntityTest.getStats().getHealth());
        assertEquals(1200, alienEntityTest.getStats().getBaseAttack());
        assertEquals(200, alienEntityTest.getStats().getDefensePoints());
    }

    @Test
    void setStats() {
        Stats newStats = new Stats(100, 100, 100, 100);
        humanEntityTest.setStats(newStats);
        alienEntityTest.setStats(newStats);

        assertEquals(100, humanEntityTest.getStats().getHealth());
        assertEquals(100, humanEntityTest.getStats().getBaseAttack());
        assertEquals(100, humanEntityTest.getStats().getDefensePoints());

        assertEquals(100, alienEntityTest.getStats().getHealth());
        assertEquals(100, alienEntityTest.getStats().getBaseAttack());
        assertEquals(100, alienEntityTest.getStats().getDefensePoints());
    }

    @Test
    void weaponMethods() {
        assertNull(humanEntityTest.getEquipedWeapon());
        assertNull(alienEntityTest.getEquipedWeapon());

        humanEntityTest.equipWeapon(battleRifle);
        alienEntityTest.equipWeapon(plasmaRifle);

        assertNotNull(humanEntityTest.getEquipedWeapon());
        assertNotNull(alienEntityTest.getEquipedWeapon());
    }


    @Test
    void attack() {
        assertEquals(500, humanEntityTest.attack());
        assertEquals(1200, alienEntityTest.attack());

        humanEntityTest.equipWeapon(battleRifle);
        alienEntityTest.equipWeapon(plasmaRifle);

        assertEquals(1500, humanEntityTest.attack());
        assertEquals(1600, alienEntityTest.attack());
    }

    @Test
    void abilityMethods() {
        assertEquals(new HashMap<>(), humanEntityTest.getAbilities());
        assertEquals(new HashMap<>(), alienEntityTest.getAbilities());

        humanEntityTest.learnAbility(brace);
        alienEntityTest.learnAbility(brace);

        HashMap<String, Ability> humanAbilities = humanEntityTest.getAbilities();
        HashMap<String, Ability> alienAbilities = alienEntityTest.getAbilities();

        assertEquals(1, humanAbilities.size());
        assertEquals(1, alienAbilities.size());

        humanEntityTest.useAbility("Brace");
        alienEntityTest.useAbility("Brace");

        // checking that the ability changed the affected stats
        assertEquals(1000, humanEntityTest.getStats().getHealth());
        assertEquals(500, humanEntityTest.getStats().getBaseAttack());
        assertEquals(1000, humanEntityTest.getStats().getDefensePoints());

        assertEquals(300, alienEntityTest.getStats().getHealth());
        assertEquals(1200, alienEntityTest.getStats().getBaseAttack());
        assertEquals(700, alienEntityTest.getStats().getDefensePoints());
    }

    @Test
    void itemMethods() {
        assertEquals(new ArrayList<>(), humanEntityTest.listItems());
        assertEquals(new ArrayList<>(), alienEntityTest.listItems());

        ArrayList<IItem> listOfHumanItems = humanEntityTest.listItems();
        ArrayList<IItem> listOfAlienItems = alienEntityTest.listItems();

        // testing if the initial size of the inventory is 0
        assertEquals(0, listOfHumanItems.size());
        assertEquals(0, listOfAlienItems.size());

        // testing the storing of weapons and testing how many we have
        humanEntityTest.storeItem(battleRifle);
        alienEntityTest.storeItem(plasmaRifle);

        ArrayList<IItem> listOfHumanWeapons = humanEntityTest.listItems("Weapon");
        ArrayList<IItem> listOfAlienWeapons = alienEntityTest.listItems("Weapon");

        assertEquals(1, listOfHumanWeapons.size());
        assertEquals(1, listOfAlienWeapons.size());

        // testing the storing of food and testing how many different foods we have
        humanEntityTest.storeItem(humanMRE);
        alienEntityTest.storeItem(alienMRE);

        ArrayList<IItem> listOfHumanFood = humanEntityTest.listItems("Food");
        ArrayList<IItem> listOfAlienFood = alienEntityTest.listItems("Food");

        assertEquals(1, listOfHumanFood.size());
        assertEquals(1, listOfAlienFood.size());

        listOfHumanItems = humanEntityTest.listItems();
        listOfAlienItems = alienEntityTest.listItems();

        Food humanMREs = (Food) listOfHumanFood.getFirst();
        Food alienMREs = (Food) listOfHumanFood.getFirst();

        assertEquals(1, humanMREs.getQuantity());
        assertEquals(1, alienMREs.getQuantity());

        assertEquals(2, listOfHumanItems.size());
        assertEquals(2, listOfAlienItems.size());

        Food MRE2 = new Food("MRE", mreDescription, mreStatsEffect, 1);
        Food MRE3 = new Food("MRE", mreDescription, mreStatsEffect, 1);
        humanEntityTest.storeItem(MRE2);
        alienEntityTest.storeItem(MRE3);

        assertEquals(2, humanMREs.getQuantity());
        assertEquals(2, alienMREs.getQuantity());

        assertEquals(2, listOfHumanItems.size());
        assertEquals(2, listOfAlienItems.size());

    }

    @Test
    void testToString() {
        humanEntityTest.learnAbility(brace);
        alienEntityTest.learnAbility(brace);

        humanEntityTest.storeItem(humanMRE);
        alienEntityTest.storeItem(alienMRE);

        humanEntityTest.storeItem(battleRifle);
        alienEntityTest.storeItem(plasmaRifle);

        String humanExpect = """
                Name: John
                Equipped Weapon: null
                Stats
                =========
                Health: 1000/1000
                Base Attack: 500
                Defense Points: 500
                
                Abilities
                ===========
                Name: Brace
                Description: Raise your defences to prepare for an attack
                Type: Universal
                
                Status Effect
                --------------
                Health: 0
                Base Attack: 0
                Defense: 500
                
                
                
                Inventory
                ===========
                Name: Battle Rifle
                Description: The BR55 Service Rifle is an infantry battle rifle in service within the armed forces of the United Nations Space Command. Among UNSC service personnel, the BR55 has accumulated a number of nicknames including the "Monkey Wrench", "BR", and the "Big Boy". It is notable for its powerful three-round burst fire and accurate 2× scope, making it more efficient at farther ranges than the MA5 series assault rifles.
                Type: Weapon
                
                Name: MRE
                Description: a self-contained, prepackaged meal designed for military and emergency use, providing a full day's caloric and nutritional requirements in a single, lightweight pouch
                Type: Food
                
                Status Effect
                --------------
                Health: 500
                Base Attack: 200
                Defense: 0
                
                """;

        String alienExpect = """
                Name: Arbiter
                Equipped Weapon: null
                Stats
                =========
                Health: 300/300
                Base Attack: 1200
                Defense Points: 200
                
                Abilities
                ===========
                Name: Brace
                Description: Raise your defences to prepare for an attack
                Type: Universal
                
                Status Effect
                --------------
                Health: 0
                Base Attack: 0
                Defense: 500
                
                
                
                Inventory
                ===========
                Name: Plasma Rifle
                Description: The Okarda'phaa-pattern Rifle (UNSC Type classification: Type-25 Directed Energy Rifle, T-25 DER), more commonly known as the plasma rifle or plasma gun, is a fully automatic rifle, formerly serving as a Covenant infantry weapon. The Type-25 DER was the primary weapon of the Covenant's officer corps, standard issue to Sangheili and Jiralhanae. However, lower-caste species within the Covenant who had attained significant rank within the Covenant military were also issued this weapon during operations. The Type-25 DER was one of the earliest and most frequently encountered Covenant plasma weapons. It occupies a role very similar to the human assault rifle.
                Type: Weapon
                
                Name: MRE
                Description: a self-contained, prepackaged meal designed for military and emergency use, providing a full day's caloric and nutritional requirements in a single, lightweight pouch
                Type: Food
                
                Status Effect
                --------------
                Health: 500
                Base Attack: 200
                Defense: 0
                
                """;

        assertEquals(humanExpect, humanEntityTest.toString());
        assertEquals(alienExpect, alienEntityTest.toString());
    }
}