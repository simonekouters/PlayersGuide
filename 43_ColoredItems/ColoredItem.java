public class ColoredItem<T> {
    private String name;
    private ConsoleColor color;
    private String colorName;

    public ColoredItem(String name, ConsoleColor color) {
        this.name = name;
        this.color = color;
        this.colorName = color.name().toLowerCase();
    }


    void display() {
        System.out.println(color.getANSI() + colorName + " " + name + ConsoleColor.RESET.getANSI());
    }

}

