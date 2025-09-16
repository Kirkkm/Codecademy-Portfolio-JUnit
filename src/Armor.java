class Armor extends Item {
    private final int defensePoints;

    public Armor(String name, String description, int defensePoints, int quantity) {

        super(name, description, "Armor", quantity);
        this.defensePoints = defensePoints;
    }

    public int getDefensePoints(){
        return defensePoints;
    }
}