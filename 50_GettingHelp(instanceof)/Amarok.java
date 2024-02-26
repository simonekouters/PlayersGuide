public class Amarok extends Room {
    
    @Override
    public void enterRoom(Player player) {
        System.out.println(ANSI.LOST + "You got killed by an Amarok!" + ANSI.RESET);
        UserInterface.gameState = GameState.DEAD;
    }

    @Override
    public void getDescription() {
        System.out.println(ANSI.AMAROK + "You can smell the rotten stench of an amarok in a nearby room." + ANSI.RESET);
    }
}
