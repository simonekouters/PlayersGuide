public class FountainRoom extends Room {
    private static boolean fountain = false;
    
    public FountainRoom() {
        super("Fountain Room");
    }

    public static void enableFountain() {
        fountain = true;
    }
    
    public static boolean fountainIsOn() {
        return fountain;
    }
    
    public static String getDescription() {
        if (!fountainIsOn()) {
            return ANSI.BLUE + "You hear water dripping in this room. The Fountain of Objects is here!" + ANSI.RESET;
        }
        return ANSI.CYAN + "You hear the rushing waters from the Fountain of Objects. It has been reactivated!" + ANSI.RESET;
    }
}
