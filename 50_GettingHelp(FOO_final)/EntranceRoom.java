public class EntranceRoom extends Room {
    public EntranceRoom() {
        super("Entrance");
    }

    public static String getDescription() {
        return ANSI.ENTRANCE + "You see light coming from the cavern entrance."+ ANSI.RESET;
    }
}
