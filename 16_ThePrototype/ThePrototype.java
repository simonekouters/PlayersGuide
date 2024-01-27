import java.util.Scanner;

public class ThePrototype {
    private static final int MAX_SCREEN_HEIGHT = 300;
    
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        int number = askForNumberInRange("User 1, enter a number between 0 and 100: ", 0, 100);

        for (int i = 0; i < MAX_SCREEN_HEIGHT; i++) {
            System.out.println();
        }
        
        System.out.println("User 2, guess the number.");

        while (true) {
            System.out.print("What is your next guess? ");
            int guess = Integer.parseInt(scanner.nextLine());
            if (guess == number) {
                break;
            } else if (guess < number) {
                System.out.println(guess + " is too low.");
            } else {
                System.out.println(guess + " is too high.");
            }
        }
        System.out.println("You guessed the number!");
    }
	public static int askForNumberInRange(String text, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int number;
        
        do {
            System.out.print(text);
            number = Integer.parseInt(scanner.nextLine());
            } while (number < min || number > max);
        return number;
    }
}