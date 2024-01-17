import java.util.Arrays;
import java.util.Scanner;

public class TheReplicatorOfDTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] Array1 = new int[5];

        for (int i = 0; i < Array1.length; i++) {
            int number = askForNumber("Enter a number: ");
            Array1[i] = number;
        }
        System.out.println("\nFirst Array: " + Arrays.toString(Array1));

        int[] Array2 = new int[5];
        for (int i = 0; i < Array1.length; i++) {
            Array2[i] = Array1[i];
        }
        System.out.println("Second Array: " + Arrays.toString(Array2));
    }
	
	public static int askForNumber(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        int number = Integer.valueOf(scanner.nextLine());
        return number;
    }
}