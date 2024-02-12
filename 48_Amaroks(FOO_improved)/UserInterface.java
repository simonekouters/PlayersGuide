import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInterface {
    private final Scanner scanner;
    private Game game;
    private PlayerPosition playerPosition;
    
    
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    } 
    
    
    public void start() {
        String gameSize = askGameSize();
        createNewGame(gameSize); 
        
        while (true) {
            if (getCurrentRoomType().equals("Entrance") && FountainRoom.fountainIsOn()) {
                System.out.println(ANSI.CYAN + "The Fountain of Objects has been reactivated, and you have escaped with your life!" + ANSI.RESET);
                System.out.println(ANSI.MAGENTA + "You win!" + ANSI.RESET);
                break;
            }
            if (getCurrentRoomType().equals("Pit")) {
                System.out.println(ANSI.RED + "You fell into a pit. You lose!" + ANSI.RESET);
                break;
            }
            if (getCurrentRoomType().equals("Amarok")) {
                System.out.println(ANSI.RED + "You encountered an amarok and died!" + ANSI.RESET);
                break;
            }
            describeRoom();
            askCommand();
            executeEncounters();
            System.out.println(ANSI.RESET + "----------------------------------------------------------------------------------");
        }
    }
    
    
    private String askGameSize() {
        String choice;
        
        System.out.println("Do you want to play a small, medium or large game?" + ANSI.GREEN);
        do {
            choice = scanner.nextLine().toLowerCase();
            if (choice.equals("small") || choice.equals("medium") || choice.equals("large")) {
                break;
            } else {
                System.out.println(ANSI.RED + "Please enter 'small', 'medium', or 'large'." + ANSI.RESET);
            }
        } while (true);
       return choice;
    }
    
    
    private void createNewGame(String gameSize) {
        int size;
        
        if (gameSize.equals("small")) {
            size = 4;
        } else if (gameSize.equals("medium")) {
            size = 6;
        } else {
            size = 8;
        }
        
        this.game = new Game(size);
        this.game.fillGrid();
        this.playerPosition = this.game.getPlayer();
    }


    private void executeEncounters() {
        if (getCurrentRoomType().equals("Maelstrom")) {
            game.maelstromEncounter();
        }
    }
    

    private String getCurrentRoomType() {
        return game.getRoomType(playerPosition.getX(), playerPosition.getY());
    }
    
    
    private Set<String> getSurroundingRooms(int directions) {
        Set<String> directRooms = new HashSet<>(); 
        Set<String> allSurroundingRooms = new HashSet<>();
        
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) { 
                continue;
                }
                int newX = playerPosition.getX() + x;
                int newY = playerPosition.getY() + y;
                if (game.roomExists(newX, newY)) {
                    if (x == 0 || y == 0) {
                        directRooms.add(game.getRoomType(newX, newY));
                        allSurroundingRooms.add(game.getRoomType(newX, newY));
                    }
                    allSurroundingRooms.add(game.getRoomType(newX, newY));
                }
            }
        }
        return directions == 4 ? directRooms : allSurroundingRooms;
    }


    private void describeRoom() {
        System.out.println(ANSI.MAGENTA + playerPosition + ANSI.RESET);

        if (getCurrentRoomType().equals("Entrance")) {
            System.out.println(EntranceRoom.getDescription());
        } else if (getCurrentRoomType().equals("Fountain Room")) {
            System.out.println(FountainRoom.getDescription());
        }

        if (getSurroundingRooms(4).contains("Pit")) {
            System.out.println(Pit.getDescription());
        }
        if (getSurroundingRooms(8).contains("Maelstrom")) {
            System.out.println(Maelstrom.getDescription());
        }
        if (getSurroundingRooms(8).contains("Amarok")) {
            System.out.println(Amarok.getDescription());
        }
    }
    
    
    private void askCommand() {
        System.out.println("What do you want to do? " + ANSI.GREEN);
        String command;
        do {
            command = scanner.nextLine().toLowerCase().trim();
            if (command.equals("move north") || command.equals("move south") || command.equals ("move east") || command.equals("move west")
                || command.equals("enable fountain")) {
                    break;
            } else {
                System.out.println(ANSI.RED + "That's not possible. Please choose a valid move." + ANSI.RESET); 
            }
        } while (true);

        switch (command) {
            case "move north" -> movePlayer("north");
            case "move south" -> movePlayer("south");
            case "move east" -> movePlayer("east");
            case "move west" -> movePlayer("west");
            case "enable fountain" -> {
                if (!getCurrentRoomType().equals("Fountain Room")) {
                    System.out.println(ANSI.RED + "You can only turn on the fountain when you are in the fountain room." + ANSI.RESET);
                } else {
                    FountainRoom.enableFountain();
                }
            }
        }
    }


    private void movePlayer(String direction) {
        int xMovement = 0;
        int yMovement = 0;

        switch (direction) {
            case "north" -> xMovement = -1;
            case "south" -> xMovement = 1;
            case "east" -> yMovement = 1;
            default -> yMovement = -1;
        }

    if (game.roomExists((playerPosition.getX() + xMovement), (playerPosition.getY()) + yMovement)) { 
            playerPosition.move(xMovement, yMovement);
        } else {
            System.out.println(ANSI.RED + "You can't go any farther in this direction, please turn around." + ANSI.RESET);
            askCommand();
        }
    }
}
