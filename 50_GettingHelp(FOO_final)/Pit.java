public class Pit extends Room {
    
    @Override
    public void enterRoom(Player player) {
        System.out.println(ANSI.LOST + "You fell into a pit. You lose!" + ANSI.RESET);
        UserInterface.gameState = GameState.DEAD;
    }
    
    @Override
    public void getDescription() {
        System.out.println(ANSI.PIT + "You feel a draft. There is a pit in a nearby room." + ANSI.RESET);
    }
}
