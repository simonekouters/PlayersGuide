import java.util.Scanner;
import java.util.List;

public class BuyingInventory {
    private static final List<Item> ITEMS = List.of(new Item("Rope", 10), 
    new Item("Torches", 15), new Item("Climbing Equipment", 25), new Item("Clean Water", 1), 
    new Item("Machete", 20), new Item("Canoe", 200), new Item("Food Supplies", 1));
    
    public static void main(String[] args) {
        displayMenu();
        
        int itemNumber = askNumber();
        Item chosenItem = ITEMS.get(itemNumber - 1);

        System.out.println("The item costs " + chosenItem.price() + " gold.");
    }
    
    
    private static void displayMenu() {
        System.out.println("MENU:");
        for (int i = 0; i < ITEMS.size(); i++) {
            System.out.println((i + 1) + "." + ITEMS.get(i).name());
        }
    }
    
    
    private static int askNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWhat number do you want to see the price of? ");
        int number = Integer.parseInt(scanner.nextLine());
        return number;
    }
}

record Item (String name, int price) {}