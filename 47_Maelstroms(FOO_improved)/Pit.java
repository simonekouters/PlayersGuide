public class Pit extends Room {
    public Pit(int x, int y, String name) {
        super(x, y, name);
    }
    
    public static String getDescription() {
        return ANSI.RED + "You feel a draft. There is a pit in a nearby room." + ANSI.RESET;
    } 
}
