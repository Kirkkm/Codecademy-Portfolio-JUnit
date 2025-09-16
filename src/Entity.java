import java.util.ArrayList;
import java.util.HashMap;

abstract class Entity {
    private String name;
    private HashMap<String, Integer> stats = new HashMap<>();
    ArrayList<Ability> abilities;
    Weapon equipedWeapon;
    HashMap<String, ArrayList<Item>> items;

    public Entity(String name, int health, int baseAttackPoint, int defensePoints){
        this.name = name;
        stats.put("health", health);
        stats.put("baseAttack", baseAttackPoint);
        stats.put("defensePoints", defensePoints);
    };

    public int attack() {
        if (this.equipedWeapon == null) {
            return stats.get("baseAttackPoint");
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
}
