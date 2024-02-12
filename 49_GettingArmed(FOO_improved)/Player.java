public class Player {
    private int xPosition;
    private int yPosition;
    private int arrows;

    public Player(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
        this.arrows = 5;
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
    
    public int getAmountOfArrows() {
        return arrows;
    }
    
    public void shootArrow() {
        arrows--;
    }
    
    @Override
    public String toString() {
        return "You are in the room at (Row=" + this.xPosition + ", Column=" 
        + this.yPosition + ")." + " Arrows left: " + arrows + ".";
    }
}
