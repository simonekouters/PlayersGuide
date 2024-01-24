public class Player {
    private int xPosition;
    private int yPosition;

    public Player(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }
    
    
    public void setX(int x) {
        this.xPosition = x;
    }
    
    
    public int getX() {
        return this.xPosition;
    }
    
    public void setY(int y) {
        this.yPosition = y;
    }
    
    
    public int getY() {
        return this.yPosition; 
    }
}