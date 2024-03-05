public class Player {
    private int xPosition;
    private int yPosition;
    private int startingX;
    private int startingY;
    private int arrows;

    public Player() {
        this.arrows = 5;
    }
    
    public void setStartingPosition(int x, int y) {
        this.startingX = x;
        this.startingY = y;
    }
    
    public int getX() {
        return xPosition;
    }
    
    public int getY() {
        return yPosition; 
    }
    
    public void move(int x, int y) {
        xPosition += x;
        yPosition += y;
    }
    
    public int getAmountOfArrows() {
        return arrows;
    }
    
    public void shootArrow() {
        arrows--;
    }
    
    public void reset() {
        this.xPosition = startingX;
        this.yPosition = startingY;
        arrows = 5;
        FountainRoom.disableFountain();
    }
    
    @Override
    public String toString() {
        return ANSI.POSITION + "You are in the room at (Row=" + xPosition + ", Column=" 
        + yPosition + ")." + " Arrows left: " + arrows + "." + ANSI.RESET;
    }
}
