import java.util.Scanner;

public class SimulasTest {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        State boxState = State.LOCKED;

        while (true) {
            System.out.print("The chest is " + boxState.getName() + "." + " What do you want to do? ");
            String command = scanner.nextLine();
            
            if (boxState.equals(State.OPEN) && command.equals("close")) {
                boxState = State.CLOSED;
            } else if (boxState.equals(State.CLOSED) && command.equals("open")) {
                boxState = State.OPEN;
            } else if (boxState.equals(State.CLOSED) && command.equals("lock")) {
                boxState = State.LOCKED;
            } else if (boxState.equals(State.LOCKED) && command.equals("unlock")) {
                boxState = State.CLOSED;
            } else {
                System.out.println("You can't " + command + " the chest, because it's " + boxState.getName() + ".");
            }
        }
    }
}