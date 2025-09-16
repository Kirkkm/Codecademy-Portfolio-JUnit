class Weapon extends Item {
    private final int attackPoints;

    public Weapon(String name, String description, int attackPoints) {

        super(name, description, "Weapon");
        this.attackPoints = attackPoints;
    }

    public int getAttackPoints() {
        return this.attackPoints;
    }
}