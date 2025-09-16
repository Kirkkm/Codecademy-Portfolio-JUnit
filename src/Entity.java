import java.util.ArrayList;
import java.util.HashMap;

abstract class Entity {
    private final String name;
    private Stats stats;
    private ArrayList<Ability> abilities;
    private Weapon equipedWeapon;
    private HashMap<String, ArrayList<Item>> items;

    public Entity(String name, int health, int baseAttackPoint, int defensePoints){
        this.name = name;
        stats = new Stats(health, baseAttackPoint, defensePoints);
    };

    public String getName() {
        return this.name;
    }

    public Stats getStats() {
        return this.stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public int attack() {
        if (this.equipedWeapon == null) {
            return stats.getBaseAttack();
        }
        return this.equipedWeapon.getAttackPoints();
    }

    public void useAbility(String ability){}
    public void learnAbility(Ability ability) {
        this.abilities.add(ability);
    }
    public ArrayList<Ability> getAbilities() {
        return this.abilities;
    }

    public void equipWeapon(Weapon weapon) {
        this.equipedWeapon = weapon;
    }

    public Weapon getEquipedWeapon() {
        return this.equipedWeapon;
    }

    public void useItem(String item){}
    public void storeItem(Item item) {
        if (!this.items.containsKey(item.getType())) {
            this.items.put(item.getType(), new ArrayList<>());
        }
        this.items.get(item.getType()).add(item);
    }

    public ArrayList<Item> getItems() {
        ArrayList<Item> allItems = new ArrayList<>();
        for (ArrayList<Item> items: this.items.values()) {
            allItems.addAll(items);
        }

        return allItems;
    }
    public ArrayList<Item> getItems(String type) {
        return this.items.get(type);
    }

    @Override
    public String toString() {
        ArrayList<Item> allItems = getItems();
        StringBuilder allItemsToString = new StringBuilder("Inventory\n===========");
        for (Item item: allItems) {
            allItemsToString.append(item.toString()).append("\n\n");
        }

        ArrayList<Ability> allAbilities = getAbilities();
        StringBuilder allAbilitiesToString = new StringBuilder("Abilities\n===========");
        for (Ability ability: allAbilities) {
            allAbilitiesToString.append(ability.toString()).append("\n\n");
        }

        return "Name: "+ this.name+"\nEquipped Weapon: "+ this.equipedWeapon+"\n"+stats.toString()+"\n"+allAbilitiesToString+"\n"+allItemsToString;
    }


}
