import java.util.function.Predicate;

public class Sieve {
    private final Predicate<Integer> predicate;

    public Sieve(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    public boolean isGood(int number) {
        return predicate.test(number);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static boolean isMultipleOf10(int number) {
        return number % 10 == 0;
    }
}
