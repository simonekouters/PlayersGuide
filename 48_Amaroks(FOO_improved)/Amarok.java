public class Amarok extends Room {
    public Amarok(int x, int y, String name) {
        super (x, y, name);
    }

    
    public static String getDescription() {
        return ANSI.RED + "You can smell the rotten stench of an amarok in a nearby room." + ANSI.RESET;
    }
}
