abstract class Item implements IItem {
    private final String name;
    private final String description;
    private final String type;
    private int quantity;

    public Item (String name, String description, String type, int quantity) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }

    public String getType() {
        return this.type;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addItem(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity += quantity;
    }

    public void removeItem(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
    }
}