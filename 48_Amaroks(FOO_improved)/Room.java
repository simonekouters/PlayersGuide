public class Room {
    private int x;
    private int y;
    private final String name;

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

    public void move (int x, int y) {
        this.x += x;
        this.y += y;
    }

    
    public String getName() {
        return this.name;
    }
}

