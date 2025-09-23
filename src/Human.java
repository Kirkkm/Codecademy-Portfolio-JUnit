public class Human extends Entity {
    private Armor equippedArmor;

    public Human(String name, int health, int healthPoints, int baseAttackPoint, int defensePoints){
        super(name, health, healthPoints, baseAttackPoint, defensePoints);
    };

    public void equipArmor(Armor armor) {
        this.equippedArmor = armor;
        this.setStats(armor.getDefensePoints(this.getStats()));

    };

    public Armor getEquippedArmor() {
        return this.equippedArmor;
    }

    public void eatFood(Food food) {
        this.setStats(food.eatFood(this.getStats()));
    };
}
