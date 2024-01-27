public class Color {
    private int red;
    private int green;
    private int blue;

    public static final  Color WHITE = new Color(255,255,255);
    public static final  Color BLACK = new Color(0,0,0);
    public static final  Color RED = new Color(255,0,0);
    public static final  Color ORANGE = new Color(255,165,0);
    public static final  Color YELLOW = new Color(255,255,0);
    public static final  Color GREEN = new Color(0,128,0);
    public static final  Color BLUE = new Color(0,0,255);
    public static final  Color PURPLE = new Color(128,0,128);

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }


    @Override
    public String toString() {
        return "Red: " + this.red + "   Green: " + this.green + "   Blue: " + this.blue;
    }
}
