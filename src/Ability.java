public class Ability {
    private final String name;
    private final String description;
    private final String type;
    private final Stats statsEffect;

    public Ability(String name, String description, String type, Stats statsEffect) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.statsEffect = statsEffect;
    }

    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public String getType() {
        return this.type;
    }

    public Stats useAbility(Stats stats) {
        stats.retoreHealth(this.statsEffect.getHealth());
        stats.updateBaseAttack(this.statsEffect.getBaseAttack());
        stats.updateDefensePoints(this.statsEffect.getDefensePoints());

        return stats;
    };

    @Override
    public String toString() {
        String statusEffect = "Status Effect\n--------------\nHealth: "+this.statsEffect.getHealth()+"\nBase Attack: "+ this.statsEffect.getBaseAttack()+"\nDefense: "+this.statsEffect.getDefensePoints();
        return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type+"\n\n" + statusEffect;
    }
}
