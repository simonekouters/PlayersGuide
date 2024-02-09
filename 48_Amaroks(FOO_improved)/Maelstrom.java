public class Maelstrom extends Room {
    public Maelstrom(int x, int y, String name) {
        super (x, y, name);
    }

    
    public static String getDescription() {
        return ANSI.RED + "You hear the growling and groaning of a maelstrom nearby." + ANSI.RESET;
    }
}
