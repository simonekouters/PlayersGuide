public class World {
    private String[][] grid;
    private int size;
    
    public World(int size) {
        this.grid = new String[size][size];
        this.size = size;
    }
    
    
    public int getSize() {
        return this.size;
    }
}