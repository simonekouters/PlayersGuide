import java.util.HashMap;

public class Board {
    private HashMap<Integer, Character> board;
    
    public Board() {
        this.board = new HashMap<>(); 
    }
    
    
    public Character getSymbol(Integer number) {
        return this.board.get(number);
    }
    
    
    public void clearBoard() {
        this.board.clear();
    }
    
    
    public void addMove(Integer number, Character symbol) {
        if (board.containsKey(number)) {
            System.out.println("That square is already occupied, please try again.");
            return;
        }
        this.board.put(number, symbol);
    }
    
    
    public void displayBoard() {
        System.out.println(" " + board.getOrDefault(7, ' ') + " | " + board.getOrDefault(8, ' ') + " | " + board.getOrDefault(9, ' '));
        System.out.println("---+---+---");
        System.out.println(" " + board.getOrDefault(4, ' ') + " | " + board.getOrDefault(5, ' ') + " | " + board.getOrDefault(6, ' '));
        System.out.println("---+---+---");
        System.out.println(" " + board.getOrDefault(1, ' ') + " | " + board.getOrDefault(2, ' ') + " | " + board.getOrDefault(3, ' '));
    }
}