import Items.Sword;
import Items.Bow;
import Items.Axe;

public class Main {
    public static void main(String[] args) {
        ColoredItem<Sword> sword = new ColoredItem<>("sword", ConsoleColor.BLUE);
        sword.display();
        
        ColoredItem<Bow> bow = new ColoredItem<>("bow", ConsoleColor.RED);
        bow.display();
        
        ColoredItem<Axe> axe = new ColoredItem<>("axe", ConsoleColor.GREEN);
        axe.display();
    }
}