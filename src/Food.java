public class Food extends Item{
    private Stats statsEffect;
    public Food(String name, String description, Stats statsEffect, int quantity) {
        this.statsEffect = statsEffect;
        super(name, description, "Food", quantity);
    }

    public Stats eatFood(Stats stats) {
        if (this.getQuantity() == 0) {
            System.out.println("You don't have enough "+ this.getName() +" food to eat!");
            return stats;
        }
        stats.retoreHealth(this.statsEffect.getHealth());
        stats.updateBaseAttack(this.statsEffect.getBaseAttack());
        stats.updateDefensePoints(this.statsEffect.getDefensePoints());

        this.removeItem(1);

        return stats;
    }

    @Override
    public String toString() {
        String statusEffect = "Status Effect\n--------------\nHealth: "+this.statsEffect.getHealth()+"\nBase Attack: "+ this.statsEffect.getBaseAttack()+"\nDefense: "+this.statsEffect.getDefensePoints();
        return "Name: " + this.getName() + "\nDescription: " + this.getDescription() + "\nType: Food\n\n"+statusEffect;
    }
}
