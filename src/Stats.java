public class Stats {
    private int health;
    private int baseAttack;
    private int defensePoints;

    Stats(int health, int baseAttack, int defensePoints) {
        this.health = health;
        this.baseAttack = baseAttack;
        this.defensePoints = defensePoints;
    }

    public int getHealth() {
        return this.health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void retoreHealth(int heal) {
        this.health += heal;
    }

    public int getBaseAttack() {
        return this.baseAttack;
    }

    public void updateBaseAttack(int attackPoints) {
        this.baseAttack += attackPoints;
    }

    public int getDefensePoints() {
        return this.defensePoints;
    }

    public void updateDefensePoints(int defensePoints) {
        this.defensePoints += defensePoints;
    }
}
