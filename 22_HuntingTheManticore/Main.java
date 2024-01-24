public class Main {
    public static void main(String[] args) {
        
        ManticoreHunting hunting = new ManticoreHunting();
        
        UserInterface ui = new UserInterface(hunting);
        ui.start();
    }
}