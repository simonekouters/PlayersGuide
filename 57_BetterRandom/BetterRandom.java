public class BetterRandom {
  public static void main(String[] args) {
    System.out.println(RandomUtils.nextDouble(10));
    System.out.println(RandomUtils.nextString("up", "down", "left", "right"));
    System.out.println(RandomUtils.coinFlip());
    System.out.println(RandomUtils.coinFlip(0.3));
  }
}
