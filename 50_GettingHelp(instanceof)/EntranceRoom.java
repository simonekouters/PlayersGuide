public class EntranceRoom extends Room {
    
    @Override
    public void enterRoom(Player player) {
        System.out.println(ANSI.ENTRANCE + "You see light coming from the cavern entrance."+ ANSI.RESET);
        if (FountainRoom.fountainIsOn()) {
            System.out.println(ANSI.WON + "The Fountain of Objects has been reactivated, and you have escaped with your life! You win!" + ANSI.RESET);
            UserInterface.gameState = GameState.WON;
        }
    }
}
