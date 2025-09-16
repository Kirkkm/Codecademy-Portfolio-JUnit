class Weapon extends Item {
    private final int attackPoints;

    public Weapon(String name, String description, int attackPoints, int quantity) {

        super(name, description, "Weapon", quantity);
        this.attackPoints = attackPoints;
    }

    public int getAttackPoints() {
        return this.attackPoints;
    }
}