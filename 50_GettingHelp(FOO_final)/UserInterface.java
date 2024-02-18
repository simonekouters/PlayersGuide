import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private Game game;
    private Player player;
    private GameDescriptions descriptions;
    
    private final List<String> commands = List.of("move north", "move south", "move east", "move west", "shoot north", 
        "shoot south", "shoot east", "shoot west", "enable fountain", "help");
    
    
    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.descriptions = new GameDescriptions();
    } 
    
    
    public void start() {
        System.out.println(descriptions.getGameDescription());
        String gameSize = askGameSize();
        createNewGame(gameSize); 
        
        while (true) {
            boolean dead = false;
            
            while (true) {
                if (getCurrentRoomType().equals("Entrance") && FountainRoom.fountainIsOn()) {
                    System.out.println(ANSI.WON + "The Fountain of Objects has been reactivated, and you have escaped with your life! You win!" + ANSI.RESET);
                    break;
                }
                if (getCurrentRoomType().equals("Pit")) {
                    System.out.println(ANSI.LOST + "You fell into a pit. You lose!" + ANSI.RESET);
                    dead = true;
                }
                if (getCurrentRoomType().equals("Amarok")) {
                    System.out.println(ANSI.LOST + "You got killed by an Amarok!" + ANSI.RESET);
                    dead = true;
                }
                if (dead) {
                    System.out.println(ANSI.RESET + "-----------------------------------------------------------------------------------------------------");
                    if (askYesOrNo("Try again? (yes/no) ").equals("yes")) {
                        dead = false;
                        player.reset();
                    } else {
                        break;
                    }   
                }
                System.out.println(ANSI.RESET + "-----------------------------------------------------------------------------------------------------");
                describeRoom();
                askCommand();
                executeEncounters();
            }
            System.out.println(ANSI.RESET + "-----------------------------------------------------------------------------------------------------");
            if (askYesOrNo("Play a new game? (yes/no) ").equals("yes")) {
                FountainRoom.disableFountain();
                System.out.println();
                start();
            } else {
                break;
            }
            break;
        }
    }
    
    
    private String askYesOrNo(String text) {
        System.out.print(ANSI.QUESTION + text + ANSI.RESET);
        do {
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("yes") || choice.equals("no")) {
                return choice;
            } else {
                System.out.print(ANSI.WARNING + "Please enter 'yes' or 'no'. " + ANSI.RESET);
            }
        } while (true);
    }
    
    
    private String askGameSize() {        
        System.out.print(ANSI.QUESTION + "Do you want to play a small, medium or large game? " + ANSI.RESET);
        do {
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("small") || choice.equals("medium") || choice.equals("large")) {
                return choice;
            } else {
                System.out.print(ANSI.WARNING + "Please enter 'small', 'medium', or 'large'. " + ANSI.RESET);
            }
        } while (true);
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
        
        player = new Player();
        game = new Game(size, player);
        game.fillGrid();
    }


    private void executeEncounters() {
        if (getCurrentRoomType().equals("Maelstrom")) {
            game.maelstromEncounter();
        }
    }
    

    private String getCurrentRoomType() {
        return game.getRoomType(player.getX(), player.getY());
    }
    
    
    private Set<String> getSurroundingRooms(int directions) {
        Set<String> directRooms = new HashSet<>(); 
        Set<String> allSurroundingRooms = new HashSet<>();
        
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) { 
                continue;
                }
                int xDirection = player.getX() + x;
                int yDirection = player.getY() + y;
                if (game.roomExists(xDirection, yDirection)) {
                    if (x == 0 || y == 0) {
                        directRooms.add(game.getRoomType(xDirection, yDirection));
                        allSurroundingRooms.add(game.getRoomType(xDirection, yDirection));
                    }
                    allSurroundingRooms.add(game.getRoomType(xDirection, yDirection));
                }
            }
        }
        return directions == 4 ? directRooms : allSurroundingRooms;
    }


    private void describeRoom() {
        System.out.println(player);

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
        System.out.print(ANSI.QUESTION + "What do you want to do? " + ANSI.RESET);
        String command;
        
        do {
            command = scanner.nextLine().toLowerCase().trim();
            if (commands.contains(command)) {
                break;
            } else {
                System.out.print(ANSI.WARNING + "That's not possible. Please choose a valid move. " + ANSI.RESET); 
            }
        } while (true);

        switch (command) {
            case "move north" -> movePlayer("north");
            case "move south" -> movePlayer("south");
            case "move east" -> movePlayer("east");
            case "move west" -> movePlayer("west");
            case "shoot north" -> shoot("north");
            case "shoot south" -> shoot("south");
            case "shoot east" -> shoot("east");
            case "shoot west" -> shoot("west");
            case "help" -> System.out.println(descriptions.getCommandDescriptions());
            case "enable fountain" -> {
                if (!getCurrentRoomType().equals("Fountain Room")) {
                    System.out.println(ANSI.WARNING + "You can only turn on the fountain when you are in the fountain room." + ANSI.RESET);
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
            case "north" -> xMovement--;
            case "south" -> xMovement++;
            case "east" -> yMovement++;
            default -> yMovement--;
        }

        if (game.roomExists((player.getX() + xMovement), (player.getY()) + yMovement)) { 
                player.move(xMovement, yMovement);
            } else {
                System.out.println(ANSI.WARNING + "There's no door here! Try another direction." + ANSI.RESET);
                askCommand();
            }
        }
    
    
    private void shoot(String direction) {
        if (player.getAmountOfArrows() == 0) {
            System.out.println(ANSI.WARNING + "You are out of arrows!" + ANSI.RESET);
            return;
        }    
        player.shootArrow();
        
        int x = player.getX();
        int y = player.getY();
        
        switch (direction) {
            case "north" -> x--;
            case "south" -> x++;
            case "east" -> y++;
            default -> y--;
        }
        
        if (game.getRoomType(x, y).equals("Amarok") || game.getRoomType(x, y).equals("Maelstrom")) {
            System.out.print(game.getRoomType(x, y).equals("Amarok") ? ANSI.KILLED + "You killed an " : ANSI.KILLED + "You killed a "); 
            System.out.println(game.getRoomType(x, y).toLowerCase() + "!" + ANSI.RESET);   
            game.removeMonster(x, y);            
        }
    }
}
