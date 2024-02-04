public class Room {
    private int x;
    private int y;
    private String name;

    public Room() {
    }

    public Room(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}