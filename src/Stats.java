public class Stats {
    private int health;
    private int healthPoints;
    private int baseAttack;
    private int defensePoints;

    Stats(int health, int healthPoints, int baseAttack, int defensePoints) {
        if (healthPoints < health) {
            throw new IllegalArgumentException("Health must be greater than or equal to health points");
        }
        if (healthPoints <= 0 || health <= 0) {
            throw new IllegalArgumentException("Health and health points cannot be less than or equal to zero!");
        }

        this.health = health;
        this.healthPoints = healthPoints;
        this.baseAttack = baseAttack;
        this.defensePoints = defensePoints;
    }

    public int getHealth() {
        return this.health;
    }

    public void takeDamage(int damage) {
        if (this.health - damage < 0) {
            this.health = 0;
        } else {
            this.health -= damage;
        }
    }

    public void retoreHealth(int heal) {
        if (this.health + heal >= this.healthPoints) {
            this.health = this.healthPoints;
        } else if (this.health == 0) {
            System.out.println("Can't restore health, Entity needs to be revived");
        } else {
            this.health += heal;
        }
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void increaseHealthPoints(int points) {
        this.healthPoints += points;
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

    @Override
    public String toString() {
        return "Stats\n=========\nHealth: "+this.health+"/"+this.healthPoints+"\nBase Attack: "+this.baseAttack+"\nDefense Points: "+this.defensePoints;

    }
}
