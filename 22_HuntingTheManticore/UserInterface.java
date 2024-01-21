import java.util.Scanner;

public class UserInterface {
	
	private ManticoreHunting hunting;
	private Scanner scanner;
	
	public UserInterface(ManticoreHunting hunting) {
		this.hunting = hunting;
		this.scanner = new Scanner(System.in);
	}
	
	
	public void start() {
        placeManticore();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Player 2, it is your turn.");
        System.out.println("-----------------------------------------------------------");
		
        while (true) {
            hunting.displayStatus();
            guess();
            if (hunting.isDestroyed()) {
                break;
            }
            hunting.nextRound();
            System.out.println("-----------------------------------------------------------");
        }
    }
	
	
    public void placeManticore() {
		System.out.print("Player 1, how far away from the city do you want to station the Manticore (enter a number between 0 and 100)? ");
		
		int number;
		do {
			number = Integer.parseInt(scanner.nextLine());
			if (number < 0 || number > 100) {
				System.out.print("Please enter a number between 0 and 100. ");
			}
		} while (number < 0 || number > 100); 
		hunting.setDistance(number);
	}
		
	
	public void guess() {
        System.out.print("Enter desired cannon range: ");
        int guess = Integer.parseInt(scanner.nextLine());
		
        if (guess == hunting.getDistance()) {
            System.out.println(ANSI.GREEN + "That round was a DIRECT HIT!" + ANSI.RESET);
			hunting.updateManticoreHealth();
        } else if (guess < hunting.getDistance()) {
            System.out.println(ANSI.YELLOW + "That round FELL SHORT of the target." + ANSI.RESET);
        } else {
            System.out.println(ANSI.CYAN + "That round OVERSHOT the target." + ANSI.RESET);
        }
		hunting.updateCityHealth();
    }
}
