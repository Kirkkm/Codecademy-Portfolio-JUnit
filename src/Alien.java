import java.util.Random;

public class Alien extends Entity {
    private int regenAmount;

    public Alien(String name, String type){
        int health;
        int baseAttackPoint;
        int defensePoints;

        if (type.equals("Tank")) {
            health = 1000;
            baseAttackPoint = 10;
            defensePoints = 1200;
            this.regenAmount = 5;
        }
        else if (type.equals("Attacker")) {
            health = 300;
            baseAttackPoint = 1200;
            defensePoints = 200;
            this.regenAmount = 15;
        }
        else {
            System.out.println("No valid type provided, using base type");
            health = 500;
            baseAttackPoint = 500;
            defensePoints = 500;
            this.regenAmount = 10;
        }

        super(name, health, health, baseAttackPoint, defensePoints);
    }

    public void mutate() {
        Random randomGenerator = new Random();

        int randomHealthStat = randomGenerator.nextInt(100);
        int randomAttackStat = randomGenerator.nextInt(100);
        int randomDefenseStat = randomGenerator.nextInt(100);

        this.getStats().increaseHealthPoints(randomHealthStat);
        this.getStats().retoreHealth(randomHealthStat);
        this.getStats().updateBaseAttack(randomAttackStat);
        this.getStats().updateDefensePoints(randomDefenseStat);
    }

    public void regen() {
        this.getStats().retoreHealth(this.regenAmount);
    }
}
