public class EntranceRoom extends Room {
    private int x;
    private int y;
    private String name;
    
    public EntranceRoom(int x, int y, String name) {
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