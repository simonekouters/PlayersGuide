import java.util.Scanner;

public class Watchtower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("x value: ");
        int x = Integer.parseInt(scanner.nextLine());
        
        System.out.print("y value: ");
        int y = Integer.parseInt(scanner.nextLine());

        if (x == 0 && y == 0) {
            System.out.println("The enemy is here!");
        } else if (x == 0 && y > 0) {
            System.out.println("The enemy is to the north!");
        } else if (x > 0 && y == 0) {
            System.out.println("The enemy is to the east!");
        } else if (x == 0 && y < 0) {
            System.out.println("The enemy is to the south!");
        } else if (x < 0 && y == 0) {
            System.out.println("The enemy is to the west!");
        } else if (x > 0 && y > 0) {
            System.out.println("The enemy is to the northeast!");
        } else if (x > 0 && y < 0) {
            System.out.println("The enemy is to the southeast!");
        } else if (x < 0 && y < 0) {
            System.out.println("The enemy is to the southwest!");
        } else {
            System.out.println("The enemy is to the northwest!");
        }
    }
}