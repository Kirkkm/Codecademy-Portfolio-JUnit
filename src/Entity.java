import java.util.ArrayList;
import java.util.HashMap;

abstract class Entity {
    String name;
    int health;
    int baseAttackPoint;
    int defensePoints;
    ArrayList<Ability> abilities;
    Weapon equipedWeapon;
    HashMap<String, ArrayList<Item>> items;

    public Entity(String name, int health, int baseAttackPoint, int defensePoints){
        this.name = name;
        this.health = health;
        this.baseAttackPoint = baseAttackPoint;
        this.defensePoints = defensePoints;
    };

    public int attack() {
        if (this.equipedWeapon == null) {
            return baseAttackPoint;
        }
        return this.equipedWeapon.attackPoints;
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
        if (!this.items.containsKey(item.type)) {
            this.items.put(item.type, new ArrayList<>());
        }
        this.items.get(item.type).add(item);
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
