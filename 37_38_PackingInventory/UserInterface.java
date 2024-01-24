import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.print("Enter the maximum amount of items of your pack: ");
        int maxItems = Integer.parseInt(scanner.nextLine());
		
        System.out.print("Enter the maximum weight of your pack: ");
        double maxWeight = Double.parseDouble(scanner.nextLine());
		
        System.out.print("Enter the maximum volume of your pack: ");
        double maxVolume = Double.parseDouble(scanner.nextLine());
		
        Pack pack = new Pack(maxItems, maxWeight, maxVolume);
		
        System.out.println("""
                \nAvailable Items:
                1. Arrow
                2. Bow
                3. Rope
                4. Water
                5. Food
                6. Sword""");


        while (true) {
            System.out.println("\n" + pack);
			
            System.out.print("Choose an item to add to your pack (enter the number of item): ");
            int item = Integer.parseInt(scanner.nextLine());
			
            if (item < 1 || item > 6) {
                System.out.println("Please enter a valid number");
                continue;
            }
            addItems(pack, item);
			
            if(pack.full()) {
                System.out.println("\nThe pack is full");
                System.out.println(pack.getStats());
                break;
            }
        }
    }


    public void addItems(Pack pack, int item) {
        InventoryItem itemToAdd = null;
		
        if (item == 1) {
            Arrow arrow = new Arrow();
            itemToAdd = arrow;
        } else if (item == 2) {
            Bow bow = new Bow();
            itemToAdd = bow;
        } else if (item == 3) {
            Rope rope = new Rope();
            itemToAdd = rope;
        } else if (item == 4) {
            Water water = new Water();
            itemToAdd = water;
        } else if (item == 5) {
            Food food = new Food();
            itemToAdd = food;
        } else {
            Sword sword = new Sword();
            itemToAdd = sword;
        }
		
        pack.add(itemToAdd);
    }
}

