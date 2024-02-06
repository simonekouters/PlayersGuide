import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.ArrayList;

public class Game {
    private final int size;
    private final EntranceRoom entranceRoom;
    private final FountainRoom fountainRoom;
    private final Map<Coordinate, Room> grid;
    private final ArrayList<Pit> pits;
    
    public Game(int size, EntranceRoom entranceRoom, FountainRoom fountainRoom, ArrayList<Pit> pits) {
        this.size = size;
        this.entranceRoom = entranceRoom;
        this.fountainRoom = fountainRoom;
        this.grid = new HashMap<>();
        this.pits = pits; 
    }
    
    
    public void fillGrid() {
        placeRoomsOnGrid();
        placePitsOnGrid();
    }


    private void placeRoomsOnGrid() {
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
    
    
    private void placePitsOnGrid() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                for (Pit pit : pits) {
                    if (x == pit.getX() && y == pit.getY()) {
                        grid.put(new Coordinate(x, y), pit);
                    }
                }
            }
        }
    }
    
    
    public boolean roomExists(int x, int y) {
        return grid.containsKey(new Coordinate(x, y));
    } 
    
    
    public String getRoomType(int x, int y) {
        if (!roomExists(x, y)) {
            return "non-existent";
        }
        return this.grid.get(new Coordinate(x, y)).getName();
    }

}