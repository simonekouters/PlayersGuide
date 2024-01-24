import java.util.Scanner;

public class TheDominionOfKings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many estates? ");
        int estates = Integer.parseInt(scanner.nextLine());
        
        System.out.print("How many duchies? ");
        int duchies = Integer.parseInt(scanner.nextLine());
        
        System.out.print("How many provinces? ");
        int provinces = Integer.parseInt(scanner.nextLine());
        
        int sum = estates + 3 * duchies + 6 * provinces;

        System.out.println("Total points: " + sum);
    }
}