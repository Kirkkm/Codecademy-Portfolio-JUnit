class Armor extends Item {
    private final int defensePoints;

    public Armor(String name, String description, int defensePoints, int quantity) {

        super(name, description, "Armor", quantity);
        this.defensePoints = defensePoints;
    }

    public Stats getDefensePoints(Stats stats){
        stats.updateDefensePoints(this.defensePoints);
        return stats;
    }
}