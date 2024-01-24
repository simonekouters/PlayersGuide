import java.util.Scanner;

public class UserInterface {
    private Robot robot;

    public UserInterface() {
        this.robot = new Robot();
    }
    
    
    public void start() {
        RobotCommand command1 = askCommand();
        RobotCommand command2 = askCommand();
        RobotCommand command3 = askCommand();
        
        robot.setCommands(command1, command2, command3);
        
        robot.run(robot);
    }


    public RobotCommand askCommand() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a command: ");
        String command = scanner.nextLine().toLowerCase().trim();

        if (command.equals("on")) {
            return new OnCommand();
        } else if (command.equals("off")) {
            return new OffCommand();
        } else if (command.equals("north")) {
            return new NorthCommand();
        } else if (command.equals("south")) {
            return new SouthCommand();
        } else if (command.equals("west")) {
            return new WestCommand();
        } else {
            return new EastCommand();
        }
    }
}
