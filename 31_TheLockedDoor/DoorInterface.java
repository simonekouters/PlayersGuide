import java.util.Scanner;

public class DoorInterface {
	
	private Scanner scanner;
	private Door door;
	
	public DoorInterface() {
		this.scanner = new Scanner(System.in);
	}
	
	
	public void start() {
		createDoor();
		askCommand();
	}
	
	
	public void createDoor() {
		System.out.print("Give a passcode to create a new door (max 9 numbers): ");
		
        int passcode = Integer.parseInt(scanner.nextLine());
        this.door = new Door(passcode);
	}
	
	
	public void askCommand() {
		while (true) {
            System.out.println("\nThe door is " + door.getState().getName());
            System.out.print("What do you want to do: 'close', 'open', 'lock', 'unlock' or 'change passcode'? ");
			
            String command = scanner.nextLine();
			
            if (command.equals("close")) {
                door.close();
            }
            if (command.equals("open")) {
                door.open();
            }
            if (command.equals("lock")) {
                door.lock();
            }
            if (command.equals("unlock")) {
                door.unlock();
            }
            if (command.equals("change passcode")) {
                changePasscode();
            }
        }
	}
	
	
	public void changePasscode() {
        while (true) {
            System.out.print("Enter your current passcode: ");
			
            int currentPasscode = Integer.parseInt(scanner.nextLine());
			
            if (currentPasscode == door.getPasscode()) {
                System.out.print("Enter a new passcode (max 9 numbers): ");
                int newPasscode = Integer.parseInt(scanner.nextLine());
                door.setPasscode(newPasscode);
                System.out.println("The passcode was changed");
                break;
            } else {
                System.out.println("Wrong passcode, try again.");
            }
        }
    }   
}