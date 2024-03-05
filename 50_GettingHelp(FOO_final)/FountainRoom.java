public class FountainRoom extends Room {
    private static boolean fountain = false;

    public static void enableFountain() {
        fountain = true;
    }
    
    public static void disableFountain() {
        fountain = false;
    }
    
    public static boolean fountainIsOn() {
        return fountain;
    }

    @Override
    public void enterRoom(Player player) {
        if (!fountainIsOn()) {
            System.out.println(ANSI.FOUNTAIN_OFF + "You hear water dripping in this room. The Fountain of Objects is here!" + ANSI.RESET);
        } else {
            System.out.println(ANSI.FOUNTAIN_ON + "You hear the rushing waters from the Fountain of Objects. It has been reactivated!" + ANSI.RESET);
        }
    }
}
