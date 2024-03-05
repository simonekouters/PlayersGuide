import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static Double nextDouble(int max) {
        return random.nextDouble(0, max);
    }

    public static String nextString(String...args) {
        int randomNumber = random.nextInt(args.length);
        return args[randomNumber];
    }

    public static boolean coinFlip() {
        return coinFlip(0.5);
    }

    public static boolean coinFlip(double probability) {
        return random.nextDouble() < probability;
    }
}


