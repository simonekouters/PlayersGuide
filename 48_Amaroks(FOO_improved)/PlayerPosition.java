public class PlayerPosition {
    private int xPosition;
    private int yPosition;

    public PlayerPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }
    
    public int getX() {
        return this.xPosition;
    }
    
    public int getY() {
        return this.yPosition; 
    }
    
    public void move(int x, int y) {
        this.xPosition += x;
        this.yPosition += y;
    }
    
    @Override
    public String toString() {
        return "You are in the room at (Row=" + this.xPosition + ", Column=" + this.yPosition + ").";
    }
}
