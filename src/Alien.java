public class Alien extends Entity {
    public Alien(String name, String type){

        int health;
        int baseAttackPoint;
        int defensePoints;

        if (type.equals("Tank")) {
            health = 1000;
            baseAttackPoint = 10;
            defensePoints = 1200;
        }
        else if (type.equals("Attacker")) {
            health = 300;
            baseAttackPoint = 1200;
            defensePoints = 200;
        }
        else {
            System.out.println("No valid type provided, using base type");
            health = 500;
            baseAttackPoint = 500;
            defensePoints = 500;
        }

        super(name, health, health, baseAttackPoint, defensePoints);
    }

    public void mutate(){}
    public void regen(){}
}
