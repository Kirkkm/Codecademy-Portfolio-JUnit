public class Human extends Entity {
    public Human(String name, int health, int baseAttackPoint, int defensePoints){
        super(name, health, baseAttackPoint, defensePoints);
    };

    public void equipArmor(Armor armor){};
    public void eatFood(Food food){};
}
