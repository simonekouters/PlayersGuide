import java.util.Scanner;

public class Robot implements RobotCommand {
    private int x;
    private int y;
    private boolean isPowered;
    private RobotCommand[] commands;


    public Robot() {
        this.x = 0;
        this.y = 0;
        this.isPowered = false;
        this.commands = new RobotCommand[3];
    }
    
    
    public void setX(int x) {
        if (!isPowered) {
            return;
        }
        this.x += x;
    }
    
    
    public void setY(int y) {
        if (!isPowered) {
            return;
        }
        this.y += y;
    }
    
    
    public void setPowered(boolean isPowered) {
        this.isPowered = isPowered;
    }


    public void setCommands(RobotCommand command1, RobotCommand command2, RobotCommand command3) {
        commands[0] = command1;
        commands[1] = command2;
        commands[2] = command3;
    }


    public void run(Robot robot) {
        for (RobotCommand command : commands) {
            command.run(this);
            System.out.printf("[%d %d %b]\n", x, y, isPowered);
        }
    }
}
