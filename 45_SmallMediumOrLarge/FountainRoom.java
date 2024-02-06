public class FountainRoom extends Room {
    private boolean fountain;
    
    public FountainRoom(int x, int y, String name) {
        super(x, y, name);
        this.fountain = false;
    }


    public void enableFountain() {
        fountain = true;
    }
    
    
    public boolean fountainIsOn() {
        return this.fountain;
    }
    
    
    @Override
    public String toString() {
        if (!fountainIsOn()) {
            return ANSI.BLUE + "You hear water dripping in this room. The Fountain of Objects is here!" + ANSI.RESET;
        }
        return ANSI.CYAN + "You hear the rushing waters from the Fountain of Objects. It has been reactivated!" + ANSI.RESET;
    }
}