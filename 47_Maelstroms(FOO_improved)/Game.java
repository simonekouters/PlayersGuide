import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Game {
    private final int size;
    private final Map<Coordinate, Room> grid;
    private final Random rand;
    private PlayerPosition player;
    
    public Game(int size) {
        this.size = size;
        this.grid = new HashMap<>(); 
        this.rand = new Random();
    }
    
    public void fillGrid() {
        createFountainRoom();
        createEntranceRoom();
        createPits();
        createMaelstroms();
        createEmptyRooms();
    }
    
    private void createEntranceRoom() {
        int x;
        int y;
        do {
            x = rand.nextInt(size - 1);
            y = rand.nextInt(size - 1);
            // to make sure the entrance is at the edge of the grid 
            if (x == 0 || y == 0) { 
                grid.put(new Coordinate(x, y), new Room(x, y, "Entrance"));
                player = new PlayerPosition(x, y);
                break;
            }
        } while (true);
    }
    
    
    private void createFountainRoom() {
        // at least 2, because I don't want it too close to the entrance
        int min = 2; 
        // -1 because the coordinates start at 0
        int max = size - 1; 
        
        int x = rand.nextInt(max - min + 1) + min; 
        int y = rand.nextInt(max - min + 1) + min; 
        grid.put(new Coordinate(x, y), new Room(x, y, "Fountain Room"));
    }
    
    
    private void createPits() {
        int amountOfPits = size / 2 - 1; 
        
        for (int i = 0; i < amountOfPits; i++) {
            do {
                int x = rand.nextInt(size - 1);
                int y = rand.nextInt(size - 1);
                if (!grid.containsKey(new Coordinate(x, y))) {
                    grid.put(new Coordinate(x, y), new Room(x, y, "Pit"));
                    break; 
                }
            } while (true);
        }
    }  
    
    private void createMaelstroms() {
        int amountOfMaelstroms = size == 8 ? 2 : 1;
        
        for (int i = 0; i < amountOfMaelstroms; i++) {
            do {
                int x = rand.nextInt(size - 1);
                int y = rand.nextInt(size - 1);
                if (!grid.containsKey(new Coordinate(x, y))) {
                    grid.put(new Coordinate(x, y), new Room(x, y, "Maelstrom"));
                    break;
                }
            } while (true);
        }
    }  
    
    private void createEmptyRooms() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (!roomExists(x, y)) {
                    grid.put(new Coordinate(x, y), new Room(x, y, "Empty Room"));
                } 
            }
        }   
    }
    
    public PlayerPosition getPlayer() {
        return this.player;
    }

    public void maelstromEncounter() {
        if (roomExists(player.getX() - 1, player.getY() + 2)) {
            player.move(-1, 2);
            System.out.println(ANSI.RED + "You have encountered a Maelstrom, you got swept to another room." + ANSI.RESET);
        } else {
            System.out.println(ANSI.GREEN + "You have encountered a Maelstrom, but you got lucky and weren't affected." + ANSI.RESET);
        }

        Room maelstrom = grid.get(new Coordinate(player.getX(), player.getY()));
        if (roomExists(maelstrom.getX() + 1, maelstrom.getY() -2)) {
            maelstrom.move(1, -2);
        } else {
            moveMaelstromToEmptyRoom(maelstrom);
        }
    }

    private void moveMaelstromToEmptyRoom(Room maelstrom) {
        do {
            int x = rand.nextInt(size - 1);
            int y = rand.nextInt(size - 1);
            if (getRoomType(x, y).equals("Empty")) {
                int currentX = maelstrom.getX();
                int currentY = maelstrom.getY();
                grid.put(new Coordinate(currentX, currentY), new Room(currentX, currentY, "Empty Room"));
                grid.put(new Coordinate(x, y), new Room(x, y, "Maelstrom"));
                return;
            }
        } while (true);
    }

    
    public boolean roomExists(int x, int y) {
        return grid.containsKey(new Coordinate(x, y));
    } 
    
    
    public String getRoomType(int x, int y) {
        if (!roomExists(x, y)) {
            return "non-existent";
        }
        return grid.get(new Coordinate(x, y)).getName();
    }
}
