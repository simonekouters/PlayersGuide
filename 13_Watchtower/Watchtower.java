import java.util.Scanner;

public class Watchtower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("x value: ");
        int x = Integer.parseInt(scanner.nextLine());
        
        System.out.print("y value: ");
        int y = Integer.parseInt(scanner.nextLine());
        
        String result = "The enemy is to the ";
        
        if (x == 0 && y == 0) {
            result = "The enemy is here";
        }
        if (y > 0) {
            result += "north";
        }
        if (y < 0) {
            result += "south";
        }
        if (x > 0) {
            result += "east";
        }
        if (x < 0) {
            result += "west";
        }
        
        System.out.println(result + "!");  
    }
}