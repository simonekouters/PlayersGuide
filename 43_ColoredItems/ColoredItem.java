public class ColoredItem<T> {
    private String name;
    private ConsoleColor color;

    public ColoredItem(String name, ConsoleColor color) {
        this.name = name;
        this.color = color;
    }
    
    void display() {
        System.out.println(color.getANSI() + color.name().toLowerCase() + " " + name + ConsoleColor.RESET.getANSI());
    }

}

