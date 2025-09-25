import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Environment  {
    private final int playersPartyLimit;
    private final int enemyPartyLimit;
    private int actionsLimit;
    private int turn;

    private final ArrayList<Entity> playersParty = new ArrayList<>();
    private final ArrayList<Entity> enemyParty = new ArrayList<>();

    public Environment(int playersPartyLimit, int enemyPartySize, int actions) {
        this.playersPartyLimit = playersPartyLimit;
        this.enemyPartyLimit = enemyPartySize;
        this.actionsLimit = actions;

        this.turn = 0;
    }

    public void addToPlayersParty(Entity partyMember) {
        if (this.playersParty.size() >= this.playersPartyLimit) {
            throw new ArrayIndexOutOfBoundsException("Player Party is Full");
        }
        
        this.playersParty.add(partyMember);
    }

    public int getPlayersPartySize() {
        return this.playersParty.size();
    }

    public void addToEnemiesParty(Entity partyMember) {
        if (this.enemyParty.size() >= this.enemyPartyLimit) {
            throw new ArrayIndexOutOfBoundsException("Enemy Party is Full");
        }

        this.enemyParty.add(partyMember);
    }

    public int getEnemiesPartySize() {
        return this.enemyParty.size();
    }

    public void playTurn() {
        System.out.println("Player's Turn!");
        if (this.playersParty.isEmpty()) {
            System.out.println("You were defeated!");
        } else if (this.enemyParty.isEmpty()) {
            System.out.println("You Won!");
        } else {

            this.checkParty(this.playersParty);
            for (int i = 0; i < this.actionsLimit; i++) {
                for (Entity partyMember : this.playersParty) {
                    System.out.println("It's " + partyMember.getName() + " turn");
                    this.useAction(partyMember);

                }
            }

            this.checkParty(this.enemyParty);
            System.out.println("Enemy's Turn!");
            for (int i = 0; i < this.actionsLimit; i++) {
                for (Entity enemy : this.enemyParty) {
                    System.out.println("It's " + enemy.getName() + " turn");
                    this.useAction(enemy);
                }
            }
            this.turn++;
        }
    }

    public void useAction(Entity partyMember) {
        boolean inTurn = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println(partyMember.getName() + " what action would you like to use?");
        System.out.println("Attack\nUse Item\nAbilities");

        while (inTurn) {
            String selectedAction = scanner.nextLine();

            switch (selectedAction) {
                case "Attack" -> {
                    int attackDmg = partyMember.attack();

                    System.out.println("Who would you like to attack? (Select 1-" + enemyParty.size() + ")");
                    this.listParty(enemyParty);
                    try {
                        int selectedEnemy = scanner.nextInt();

                        Entity enemy = enemyParty.get(selectedEnemy);
                        enemy.takeDamage(attackDmg);

                        inTurn = false;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Please select a valid enemy...");
                    }
                }
                case "Use Item" -> {
                    System.out.println("Select an item to use... (type in the item number)");
                    ArrayList<IItem> itemsList = partyMember.listItems();
                    this.listItems(itemsList);
                    if (!itemsList.isEmpty()) {
                        try {
                            int selectedItem = scanner.nextInt();
                            Item item = (Item) itemsList.get(selectedItem);
                            partyMember.useItem(item);

                            inTurn = false;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Please select a valid Item...");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Please select a valid Item...");
                            System.out.println(e.getMessage());
                        }
                    }
                }
                case "Abilities" -> {
                    System.out.println("Select an ability to use... (type in the ability name)");
                    HashMap<String, Ability> abilities = partyMember.getAbilities();
                    this.listAbilities(abilities);
                    try {
                        String selectedAbility = scanner.nextLine();
                        partyMember.useAbility(selectedAbility);
                        inTurn = false;
                    } catch (Exception e) {
                        System.out.println("Please select a valid ability...");
                        System.out.println(e.getMessage());
                    }
                }
                default -> System.out.println("Invalid Input, please try again");
            }
        }
    }

    private void listParty(ArrayList<Entity> party) {
        for (int i = 0; i < party.size(); i++) {
            String name = party.get(i).getName();
            int health = party.get(i).getStats().getHealth();
            int healthPoints = party.get(i).getStats().getHealthPoints();
            System.out.println("["+i+"]: " +name+"\nHealth: " + health + "/"+ healthPoints);
        }
    }

    private void checkParty(ArrayList<Entity> party) {
        for (Entity partyMember : party) {
            if (partyMember.getStats().getHealth() == 0) {
                this.playersParty.remove(partyMember);
            }
        }
    }

    private void listItems(ArrayList<IItem> itemsList) {
        if  (itemsList.isEmpty()) {
            System.out.println("No items in you inventory");
        } else {
            System.out.println("Items\n===========\n");
            for (int i = 0; i < itemsList.size(); i++) {
                System.out.println("[" + i + "]: " + itemsList.get(i).toString());
                System.out.println("-----------------------------\n");
            }
        }
    }

    private void listAbilities(HashMap<String, Ability> allAbilities) {
        if  (allAbilities.isEmpty()) {
            System.out.println("You don't know any abilities");
        } else {
            ArrayList<Ability> abilitiesList = (ArrayList<Ability>) allAbilities.values();
            System.out.println("Abilities\n===========\n");

            for (int i = 0; abilitiesList.size() > i; i++) {
                System.out.println("abilitiesList.get(i).toString()");
                System.out.println("-----------------------------\n");
            }
        }
    }
}
