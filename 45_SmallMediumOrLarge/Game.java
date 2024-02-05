import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class Game {
    private final int size;
    private final EntranceRoom entranceRoom;
    private final FountainRoom fountainRoom;
    private final Map<Coordinate, Room> grid;
    
    public Game(int size, EntranceRoom entranceRoom, FountainRoom fountainRoom) {
        this.size = size;
        this.entranceRoom = entranceRoom;
        this.fountainRoom = fountainRoom;
        this.grid = new HashMap<>();
        
        placeRoomsOnGrid();
    }
    
    public void placeRoomsOnGrid() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (x == entranceRoom.getX() && y == entranceRoom.getY()) {
                    grid.put(new Coordinate(x, y), entranceRoom);
                } else if (x == fountainRoom.getX() && y == fountainRoom.getY()) {
                    grid.put(new Coordinate(x, y), fountainRoom);
                } else {
                    grid.put(new Coordinate(x, y), new Room(x, y, "Empty room"));
                }  
            }
        }
    }
    
    public boolean roomExists(int x, int y) {
        return grid.containsKey(new Coordinate(x, y));
    } 
    
    public int getSize() {
        return this.size;
    }
}