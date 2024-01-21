import java.util.Scanner;
import java.awt.Toolkit;

public class TheDefenseOfConsolas {
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Target Row? ");
        int row = Integer.parseInt(scanner.nextLine());
		
        System.out.print("Target Column? ");
        int column = Integer.parseInt(scanner.nextLine());

        System.out.println("Deploy to: ");
        System.out.println(ANSI_RED + "(" + row + ", " + (column - 1) + ")");
        System.out.println("(" + (row - 1) + ", " + column + ")");
        System.out.println("(" + row + ", " + (column + 1) + ")");
        System.out.println("(" + (row + 1) + ", " + column + ")");

        Toolkit.getDefaultToolkit().beep();
    }
}