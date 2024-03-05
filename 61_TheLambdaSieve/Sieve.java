import java.util.function.Predicate;

public class Sieve {
    private final Predicate<Integer> predicate;

    public Sieve(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    public boolean isGood(int number) {
        return predicate.test(number);
    }
}
