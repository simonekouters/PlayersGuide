import java.util.Scanner;

public class RepairingTheClocktower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number: ");
        int number = Integer.parseInt(scanner.nextLine());

        if (number % 2 == 0) {
            System.out.println("Tick");
        } else {
            System.out.println("Tock");
        }
    }
}