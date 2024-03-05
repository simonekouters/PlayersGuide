public class Maelstrom extends Room {
    
    @Override
    public void getDescription() {
        System.out.println(ANSI.MAELSTROM + "You hear the growling and groaning of a maelstrom nearby." + ANSI.RESET);
    }
}
