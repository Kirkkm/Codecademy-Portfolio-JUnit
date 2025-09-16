public class Ability {
    String name;
    String description;
    String type;

    public Ability(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }
    // public int effect(){};

    @Override
    public String toString() {
        return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
    }
}
