import java.util.Scanner;

public class UserInterface {
    private World world;
    private FountainRoom fountainRoom;
    
    private Player player;
    private Scanner scanner;
    
    
    public UserInterface(World world, FountainRoom fountainRoom) {
        this.world = world;
        this.fountainRoom = fountainRoom;
        
        this.scanner = new Scanner(System.in);
        this.player = new Player(0, 0);
    } 
    
    
    public void start() {
        while (true) {
            if (playerIsAtEntrance() && fountainRoom.fountainIsOn()) {
                System.out.println(ANSI.CYAN + "The Fountain of Objects has been reactivated, and you have escaped with your life!" + ANSI.RESET);
                System.out.println(ANSI.MAGENTA + "You win!" + ANSI.RESET);
                break;
            }
            describeRoom();
            askCommand();
            System.out.println(ANSI.RESET + "----------------------------------------------------------------------------------");
        }
    }
    
    
    public void describeRoom() {
        System.out.println("You are in the room at (Row=" + player.getX() + ", Column=" + player.getY() + ").");
        if (player.getX() == 0 && player.getY() == 0) {
            System.out.println(ANSI.YELLOW + "You see light coming from the cavern entrance."+ ANSI.RESET);
        }
        if (playerIsInFountainRoom() && !fountainRoom.fountainIsOn()) {
            System.out.println(ANSI.BLUE + "You hear water dripping in this room. The Fountain of Objects is here!" + ANSI.RESET);
        }           
        if (playerIsInFountainRoom() && fountainRoom.fountainIsOn()) {
            System.out.println(ANSI.CYAN + "You hear the rushing waters from the Fountain of Objects. It has been reactivated!" + ANSI.RESET);
        }
    }
    
    
    public void askCommand() {
        System.out.print("What do you want to do? " + ANSI.GREEN);
        String command = scanner.nextLine();
        
        if (command.toLowerCase().trim().equals("move north")) {
            moveNorth();
        } else if (command.toLowerCase().trim().equals("move south")) {
            moveSouth(); 
        } else if (command.toLowerCase().trim().equals("move east")) {
            moveEast();
        } else if (command.toLowerCase().trim().equals("move west")) {
            moveWest();
        } else if (command.toLowerCase().trim().equals("enable fountain")) {
            if (!playerIsInFountainRoom()) {
                System.out.println(ANSI.RED + "You can only turn on the fountain when you are in the fountain room." + ANSI.RESET);
            } else {
                fountainRoom.enableFountain();
            }
        } else {
            System.out.println("That's not possible. Please choose a valid move."); 
            askCommand();
        }
    }
    
    
    public boolean playerIsInFountainRoom() {
        return this.player.getX() == this.fountainRoom.getX() && this.player.getY() == this.fountainRoom.getY();
    }
    
    
    public boolean playerIsAtEntrance() {
        return this.player.getX() == 0 && this.player.getY() == 0;
    }

    
    public void moveNorth() {
        if (player.getX() == 0) {
                System.out.println(ANSI.RED + "You can't go any farther in this direction, please turn around." + ANSI.RESET);
                askCommand();
                return;
            }
        player.setX(player.getX() - 1);
    }
    
    
    public void moveSouth() {
        if (player.getX() == world.getSize() - 1) {
                System.out.println(ANSI.RED + "You can't go any farther in this direction, please turn around." + ANSI.RESET);
                askCommand();
                return;
            }
        player.setX(player.getX() + 1);
    }
    
    
    public void moveEast() {
        if (player.getY() == world.getSize() - 1) {
                System.out.println(ANSI.RED + "You can't go any farther in this direction, please turn around." + ANSI.RESET);
                askCommand();
                return;
            }
        player.setY(player.getY() + 1);
    }
    
    
    public void moveWest() {
        if (player.getY() == 0) {
                System.out.println(ANSI.RED + "You can't go any farther in this direction, please turn around." + ANSI.RESET);
                askCommand();
                return;
            }
        player.setY(player.getY() - 1);
    }
}