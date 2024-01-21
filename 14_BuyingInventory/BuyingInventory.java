import java.util.Scanner;

public class BuyingInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("MENU:");
        System.out.println("1.Rope\n" + "2.Torches\n" + "3.Climbing Equipment\n" +
                "4.Clean Water\n" + "5.Machete\n" + "6.Canoe\n" + "7.Food Supplies\n");
				
        System.out.print("What number do you want to see the price of? ");
        int item = Integer.parseInt(scanner.nextLine());

        int price = switch (item) {
            case 1 -> 10;
            case 2 -> 15;
            case 3 -> 25;
            case 4, 7 -> 1;
            case 5 -> 20;
            case 6 -> 200;
            default -> throw new IllegalArgumentException("Invalid item number");
        };
        System.out.println("The item costs " + price + " gold.");
    }
}