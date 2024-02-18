public class Amarok extends Room {
    public Amarok() {
        super("Amarok");
    }

    public static String getDescription() {
        return ANSI.AMAROK + "You can smell the rotten stench of an amarok in a nearby room." + ANSI.RESET;
    }
}
