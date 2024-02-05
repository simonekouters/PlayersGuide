public class FountainRoom extends Room {
    private final int x;
    private final int y;
    private final String name;
    private boolean fountain;
    
    public FountainRoom(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.fountain = false;
    }
    
    
    public int getX() {
        return this.x;
    }
    
    
    public int getY() {
        return this.y;
    }


    public void enableFountain() {
        fountain = true;
    }
    
    
    public boolean fountainIsOn() {
        return this.fountain;
    }
}