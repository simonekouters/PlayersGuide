public class Pit extends Room {
    public Pit() {
        super("Pit");
    }
    
    public static String getDescription() {
        return ANSI.RED + "You feel a draft. There is a pit in a nearby room." + ANSI.RESET;
    } 
}
