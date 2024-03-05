import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  private static Sieve sieve;
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    askSieveChoice();
    askNumbersToSieve();
  }

  private static void askSieveChoice() {
    System.out.println("""
            Which sieve do you want to use?
            1. Check if number is even
            2. Check if number is positive
            3. Check if number is a multiple of ten
            """);

    do {
      try {
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
          case 1 -> sieve = new Sieve(Sieve::isEven);
          case 2 -> sieve = new Sieve(Sieve::isPositive);
          case 3 -> sieve = new Sieve(Sieve::isMultipleOf10);
          default -> {
            System.out.println("That's not an option.");
            continue;
          }
        }
      } catch (InputMismatchException e) {
        System.out.println("That's not a number.");
        continue;
      }
      break;
    } while (true);
  }

  private static void askNumbersToSieve() {
    do {
      System.out.println("Enter a number to see if it passes the test: ");
      try {
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(sieve.isGood(number));
      } catch (InputMismatchException e) {
        System.out.println("That's not a number.");
      }
    } while (true);
  }
}



