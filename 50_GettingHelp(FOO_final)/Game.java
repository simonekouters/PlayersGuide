import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Game {
    private final int size;
    private Map<Coordinate, Room> grid;
    private final Random rand;
    private final Player player;
    
    public Game(int size, Player player) {
        this.size = size;
        this.grid = new HashMap<>(); 
        this.rand = new Random();
        this.player = player;
    }
    
    public void fillGrid() {
        createFountainRoom();
        createEntranceRoom();
        
        int amountOfPits = size / 2 - 1; 
        int amountOfMaelstroms = size == 8 ? 2 : 1;
        int amountOfAmaroks = size / 2 - 1; 
        
        createObstacles(amountOfPits, new Pit());
        createObstacles(amountOfMaelstroms, new Maelstrom());
        createObstacles(amountOfAmaroks, new Amarok());
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
                grid.put(new Coordinate(x, y), new EntranceRoom());
                player.move(x, y);
                player.setStartingPosition(x, y);
                break;
            }
        } while (true);
    }
    
    
    private void createFountainRoom() {
        // at least 2, because I don't want it too close to the entrance
        int min = 2; 
        int max = size - 1; 
        
        int x = rand.nextInt(max - min + 1) + min; 
        int y = rand.nextInt(max - min + 1) + min; 
        grid.put(new Coordinate(x, y), new FountainRoom());
    }
    
    
    private void createObstacles(int amount, Room roomType) {
        for (int i = 0; i < amount; i++) {
            do {
                int x = rand.nextInt(size - 1);
                int y = rand.nextInt(size - 1);
                if (!grid.containsKey(new Coordinate(x, y))) {
                    grid.put(new Coordinate(x, y), roomType);
                    break; 
                }
            } while (true);
        }
    }
    
    
    private void createEmptyRooms() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (!roomExists(x, y)) {
                    grid.put(new Coordinate(x, y), new EmptyRoom());
                } 
            }
        }   
    }


    public void maelstromEncounter() {
        int currentX = player.getX();
        int currentY = player.getY();
        
        if (roomExists(player.getX() + 1, player.getY() + 2)) {
            player.move(1, 2);
            System.out.println(ANSI.WARNING + "You have encountered a Maelstrom, you got swept to another room." + ANSI.RESET);
        } else {
            System.out.println(ANSI.WARNING + "You have encountered a Maelstrom, but you got lucky and weren't affected." + ANSI.RESET);
        }

        if (roomExists(currentX + 1 , currentY - 2) && getRoomType(currentX + 1, currentY - 2).equals("Empty Room")) {
            grid.put(new Coordinate(currentX + 1, currentY - 2), new Maelstrom());
            grid.put(new Coordinate(currentX, currentY), new EmptyRoom());
        } else {
            moveMaelstromToEmptyRoom(currentX, currentY);
        }
    }


    private void moveMaelstromToEmptyRoom(int currentX, int currentY) {
        do {
            int x = rand.nextInt(size - 1);
            int y = rand.nextInt(size - 1);
            if (getRoomType(x, y).equals("Empty Room")) {
                grid.put(new Coordinate(x, y), new Maelstrom());
                grid.put(new Coordinate(currentX, currentY), new EmptyRoom());
                return;
            }
        } while (true);
    }
    
    
    public void removeMonster(int x, int y) {
        grid.put(new Coordinate(x, y), new EmptyRoom());      
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
