public class TheMagicCannon {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            String blast = "";
            if (i % 5 == 0 && i % 3 == 0) {
                blast = ANSI_BLUE + "Electric and Fire" + ANSI_RESET;
            } else if (i % 5 == 0) {
                blast = ANSI_YELLOW + "Electric" + ANSI_RESET;
            } else if (i % 3 == 0) {
                blast = ANSI_RED + "Fire" + ANSI_RESET;
            } else {
                blast = ANSI_WHITE + "Normal" + ANSI_RESET;
            }
            System.out.println(i + ": " + blast);
        }
    }
}