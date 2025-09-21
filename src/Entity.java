import java.util.ArrayList;
import java.util.HashMap;

abstract class Entity {
    private final String name;
    private Stats stats;
    private final HashMap<String, Ability> abilities = new HashMap<>();
    private Weapon equipedWeapon;
    private final HashMap<String, ArrayList<IItem>> items = new HashMap<>();

    public Entity(String name, int health, int baseAttackPoint, int defensePoints){
        this.name = name;
        this.stats = new Stats(health, baseAttackPoint, defensePoints);
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

    public void equipWeapon(Weapon weapon) {
        this.equipedWeapon = weapon;
    }

    public Weapon getEquipedWeapon() {
        return this.equipedWeapon;
    }

    public int attack() {
        if (this.equipedWeapon == null) {
            return stats.getBaseAttack();
        }
        return this.equipedWeapon.getAttackPoints();
    }

    public void learnAbility(Ability ability) {
        this.abilities.put(ability.getName(), ability);
    }

    public HashMap<String, Ability> getAbilities() {
        return this.abilities;
    }

    public void useAbility(String ability) {
        Ability abilityToUse = this.abilities.get(ability);
        this.stats = abilityToUse.useAbility(this.stats);
    }

    public void storeItem(Item item) {
        if (!this.items.containsKey(item.getType())) {
            this.items.put(item.getType(), new ArrayList<>());
        }

        // checking if we already have a stored item
        for (IItem i : this.items.get(item.getType())) {
            // if we find a matching Item we update its quantity
            if (i.getName().equals(item.getName())) {
                i.addItem(item.getQuantity());
                return;
            }
        }

        this.items.get(item.getType()).add(item);
    }

    public ArrayList<IItem> listItems() {
        ArrayList<IItem> allItems = new ArrayList<>();
        for (ArrayList<IItem> items: this.items.values()) {
            allItems.addAll(items);
        }

        return allItems;
    }
    public ArrayList<IItem> listItems(String type) {
        return this.items.get(type);
    }

    @Override
    public String toString() {
        ArrayList<IItem> allItems = listItems();
        StringBuilder allItemsToString = new StringBuilder("\nInventory\n===========\n");
        for (IItem item: allItems) {
            allItemsToString.append(item.toString()).append("\n\n");
        }

        HashMap<String, Ability> allAbilities = getAbilities();
        StringBuilder allAbilitiesToString = new StringBuilder("\nAbilities\n===========\n");
        for (Ability ability: allAbilities.values()) {
            allAbilitiesToString.append(ability.toString()).append("\n\n");
        }

        return "Name: "+ this.name+"\nEquipped Weapon: "+ this.equipedWeapon+"\n"+stats.toString()+"\n"+allAbilitiesToString+"\n"+allItemsToString;
    }


}
