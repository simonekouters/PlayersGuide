import java.util.Optional;
import java.util.Scanner;

public class SaferNumberCrunching {
  private final Scanner scanner = new Scanner(System.in);

  private Optional<Integer> getInteger() {
    Optional<Integer> number;
    do {
      number = askInteger();
    } while (number.isEmpty());
    return number;
  }

  private Optional<Integer> askInteger() {
    Optional<Integer> number = Optional.empty();
    System.out.println("Enter an integer: ");
    try {
      number = Optional.of(Integer.parseInt(scanner.nextLine()));
    } catch (Exception e) {
      System.out.println("That's not an integer.");
    }
    return number;
  }


  private Optional<Double> getDouble() {
    Optional<Double> number;
    do {
      number = askDouble();
    } while (number.isEmpty());
    return number;
  }

  private Optional<Double> askDouble() {
    Optional<Double> number = Optional.empty();
    System.out.println("Enter a double: ");
    try {
      number = Optional.of(Double.parseDouble(scanner.nextLine()));
    } catch (Exception e) {
      System.out.println("That's not a double.");
    }
    return number;
  }


  private Optional<Boolean> getBoolean() {
    Optional<Boolean> bool;
    do {
      bool = askBoolean();
    } while (bool.isEmpty());
    return bool;
  }

  private Optional<Boolean> askBoolean() {
    Optional<Boolean> bool = Optional.empty();
    System.out.println("Enter a boolean: ");
    try {
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
        bool = Optional.of(Boolean.parseBoolean(input));
      } else {
          System.out.println("That's not a boolean.");
      }
    } catch (Exception e) {
      return Optional.empty();
    }
    return bool;
  }
}


