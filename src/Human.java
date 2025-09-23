public class Human extends Entity {
    private Armor equippedArmor;

    public Human(String name, int health, int baseAttackPoint, int defensePoints){
        super(name, health, baseAttackPoint, defensePoints);
    };

    public void equipArmor(Armor armor) {
        equippedArmor = armor;

    };
    public void eatFood(Food food) {
        this.setStats(food.eatFood(this.getStats()));
    };
}
