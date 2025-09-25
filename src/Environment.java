import java.util.ArrayList;
import java.util.Scanner;

public class Environment  {
    private final int playersPartyLimit;
    private final int enemyPartyLimit;
    private int actions;
    private int turn;

    private final ArrayList<Entity> playersParty = new ArrayList<>();
    private final ArrayList<Entity> enemyParty = new ArrayList<>();

    public Environment(int playersPartyLimit, int enemyPartySize, int actions) {
        this.playersPartyLimit = playersPartyLimit;
        this.enemyPartyLimit = enemyPartySize;
        this.actions = actions;

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
        for (Entity partyMember : this.playersParty) {
            System.out.println("It's " + partyMember.getName() + " turn");

        }

        this.turn++;
    }

    public void useAction(Entity partyMember) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(partyMember.getName() + " what action would you like to use?");
        System.out.println("Attack\nUse Item\nAbilities");
        String selectedAction = scanner.nextLine();

        switch (selectedAction) {
            case "Attack" -> {
                int attackDmg = partyMember.attack();

                System.out.println("Who would you like to attack? (Select 1-" + enemyParty.size() + ")");
                this.listParty(enemyParty);
                int selectedEnemy = scanner.nextInt();

                Entity enemy = enemyParty.get(selectedEnemy);
                enemy.takeDamage(attackDmg);
            }
            case "Use Item" -> {
                System.out.println("Select an item to use...");
                ArrayList<IItem> itemsList = partyMember.listItems();
                this.listItems(itemsList);

                int selectedItem = scanner.nextInt();
                IItem item = itemsList.get(selectedItem);



                System.out.println("Who would you like to use "+ item.getName() +" on? (Select 1-" + playersParty.size() + ")");
                this.listParty(this.playersParty);

                int selectedPlayer = scanner.nextInt();
                //Entity partymember = playersParty.get(selectedPlayer);

            }
            case "Abilities" -> {
            }
            default -> System.out.println("Invalid Input, please try again");
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

    private void listItems(ArrayList<IItem> itemsList) {
        for (int i = 0; i < itemsList.size(); i++) {
            System.out.println("["+i+"]: " + itemsList.get(i).toString());
        }
    }
}
