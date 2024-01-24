public class FountainRoom {
    private int x;
    private int y;
    private boolean fountain;
    
    public FountainRoom(int x, int y) {
        this.x = x;
        this.y = y;
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