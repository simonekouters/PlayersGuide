import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DiscountedInventory {
    private static final List<Item> items = new ArrayList<>(List.of(new Item("Rope", 10), 
    new Item("Torches", 15), new Item("Climbing Equipment", 25), new Item("Clean Water", 1), 
    new Item("Machete", 20), new Item("Canoe", 200), new Item("Food Supplies", 1)));
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        displayMenu();
        
        int itemNumber = askNumber();
        Item chosenItem = items.get(itemNumber - 1);
        
        if (nameIsMyName()) {
            System.out.println("The item costs " + 0.5 * chosenItem.price() + " gold.");
        } else {
            System.out.println("The item costs " + chosenItem.price() + " gold.");
        }
    }
    
    
    private static void displayMenu() {
        System.out.println("MENU:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + "." + items.get(i).name());
        }
    }
    
    
    private static int askNumber() {
        System.out.print("\nWhat number do you want to see the price of? ");
        int number = Integer.parseInt(scanner.nextLine());
        return number;
    }
    
    
    private static boolean nameIsMyName() {
        System.out.print("What's your name? ");
        String name = scanner.nextLine();
        return name.toLowerCase().equals("simone");
    }
}

record Item (String name, int price) {}