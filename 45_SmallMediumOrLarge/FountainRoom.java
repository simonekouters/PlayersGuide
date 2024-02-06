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
}