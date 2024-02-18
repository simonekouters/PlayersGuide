public class Maelstrom extends Room {
    public Maelstrom() {
        super("Maelstrom");
    }
    
    public static String getDescription() {
        return ANSI.MAELSTROM + "You hear the growling and groaning of a maelstrom nearby." + ANSI.RESET;
    }
}
