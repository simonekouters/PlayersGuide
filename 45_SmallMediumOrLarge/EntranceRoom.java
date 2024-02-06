public class EntranceRoom extends Room {
    
    public EntranceRoom(int x, int y, String name) {
        super(x, y, name);
    }
    
    @Override
    public String toString() {
        return ANSI.YELLOW + "You see light coming from the cavern entrance."+ ANSI.RESET;
    }
}