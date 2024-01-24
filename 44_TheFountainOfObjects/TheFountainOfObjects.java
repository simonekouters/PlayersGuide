public class TheFountainOfObjects {
    public static void main(String[] args) {
        FountainRoom fountainRoom = new FountainRoom(0, 2);
        
        World world = new World(4);
        
        UserInterface ui = new UserInterface(world, fountainRoom);
        ui.start();
    }
}