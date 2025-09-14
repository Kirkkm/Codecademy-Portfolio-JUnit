class Armor extends Item {
    int defensePoints;

    public Armor(String name, String description, int defensePoints) {

        super(name, description, "Armor");
        this.defensePoints = defensePoints;
    }

    public int getDefensePoints(){
        return defensePoints;
    }
}