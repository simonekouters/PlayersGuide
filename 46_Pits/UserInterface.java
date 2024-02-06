import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class UserInterface {
    private final Scanner scanner;
    private Game game;
    private EntranceRoom entranceRoom;
    private FountainRoom fountainRoom;
    private PlayerPosition playerPosition;
    
    
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    } 
    
    
    public void start() {
        String gameSize = askGameSize();
        createNewGame(gameSize); 
        
        while (true) {
            describeRoom();
            if (currentRoomType().equals("Entrance") && fountainRoom.fountainIsOn()) {
                System.out.println(ANSI.CYAN + "The Fountain of Objects has been reactivated, and you have escaped with your life!" + ANSI.RESET);
                System.out.println(ANSI.MAGENTA + "You win!" + ANSI.RESET);
                break;
            }
            if (currentRoomType().equals("Pit")) {
                System.out.println(ANSI.RED + "You fell into a pit. You lose!" + ANSI.RESET);
                break;
            }
            askCommand();
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
        
        this.entranceRoom = createEntranceRoom(size);
        this.fountainRoom = createFountainRoom(size);
        this.playerPosition = new PlayerPosition(entranceRoom.getX(), entranceRoom.getY());
        
        int amountOfPits = size / 2 - 1;
        ArrayList<Pit> pits = new ArrayList<>();
        
        for (int i = 0; i < amountOfPits; i++) {
            Pit newPit = createPit(size);
            pits.add(newPit);
        }
        
        this.game = new Game(size, this.entranceRoom, this.fountainRoom, pits);
        this.game.fillGrid();
    }
    
    
    private EntranceRoom createEntranceRoom(int size) {
        Random rand = new Random();
        int x;
        int y;
     
        do {
            x = rand.nextInt(size - 1);
            y = rand.nextInt(size - 1);
            // to make sure the entrance is at the edge of the grid 
            if (x == 0 || y == 0) { 
                break;
            }
        } while (true);
        
        return new EntranceRoom(x, y, "Entrance");
    }
    
    
    private FountainRoom createFountainRoom(int size) {
        Random rand = new Random();
        // at least 2, because I don't want it too close to the entrance
        int min = 2; 
        // -1 because the coordinates start at 0
        int max = size - 1; 
        
        int x = rand.nextInt(max - min + 1) + min; 
        int y = rand.nextInt(max - min + 1) + min; 
        
        return new FountainRoom(x, y, "Fountain Room");
    }
    
    
    private Pit createPit(int size) {
        Random rand = new Random();
        int x;
        int y;

        do {
            x = rand.nextInt(size - 1);
            y = rand.nextInt(size - 1);
            if (x != fountainRoom.getX() && y != fountainRoom.getY() &&
                x != entranceRoom.getX() && y != entranceRoom.getY()) {
                break;
            }
        } while (true);
        return new Pit(x, y, "Pit");
    }


    private String currentRoomType() {
        return game.getRoomType(playerPosition.getX(), playerPosition.getY());
    }
  
    
    private void describeRoom() {
        System.out.println(ANSI.MAGENTA + playerPosition + ANSI.RESET);
        
        if (currentRoomType().equals("Entrance")) {
            System.out.println(entranceRoom.toString());
        }
        if (currentRoomType().equals("Fountain Room")) {
            System.out.println(fountainRoom.toString());
        }
        if (surroundingRooms().contains("Pit")) {
            System.out.println(ANSI.RED + "You feel a draft. There is a pit in a nearby room." + ANSI.RESET);
        }
    }
    
    
    private void askCommand() {
        System.out.println("What do you want to do? ('move north', 'move south', 'move east', 'move west' or 'enable fountain') " + ANSI.GREEN);
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
                if (!currentRoomType().equals("Fountain Room")) {
                    System.out.println(ANSI.RED + "You can only turn on the fountain when you are in the fountain room." + ANSI.RESET);
                } else {
                    fountainRoom.enableFountain();
                }
            }
        }
    }


    private List<String> surroundingRooms() {
        String room1 = game.getRoomType(playerPosition.getX() + 1, playerPosition.getY());
        String room2 = game.getRoomType(playerPosition.getX() - 1, playerPosition.getY());
        String room3 = game.getRoomType(playerPosition.getX(), playerPosition.getY() + 1);
        String room4 = game.getRoomType(playerPosition.getX(), playerPosition.getY() - 1);

        return List.of(room1, room2, room3, room4);
    }


    private void movePlayer(String direction) {
        int x;
        int y;

        switch (direction) {
            case "north" -> {
                x = playerPosition.getX() - 1;
                y = playerPosition.getY();
            }
            case "south" -> {
                x = playerPosition.getX() + 1;
                y = playerPosition.getY();
            }
            case "east" -> {
                x = playerPosition.getX();
                y = playerPosition.getY() + 1;
            }
            default -> {
                x = playerPosition.getX();
                y = playerPosition.getY() - 1;
            }
        }

        if (game.roomExists(x, y)) {
            playerPosition.setX(x);
            playerPosition.setY(y);
        } else {
            System.out.println(ANSI.RED + "You can't go any farther in this direction, please turn around." + ANSI.RESET);
            askCommand();
        }
    }
}