public class Game {
    private String player1;
    private String player2;
    
    private int player1Wins;
    private int player2Wins;
    
    private Board board;


    public Game(String player1, String player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        
        this.player1Wins = 0;
        this.player2Wins = 0;
        
        this.board = board;
    }
    
    
    public String getPlayer1() {
        return this.player1;
    }
    
    
    public String getPlayer2() {
        return this.player2;
    }
    
    
    public int getPlayer1Wins() {
        return this.player1Wins;
    }
    
    
    public int getPlayer2Wins() {
        return this.player2Wins;
    }
    
    
    public void move(int number, String player) {
        if (player.equals(this.player1)) {
            board.addMove(number, 'X');
        } else {
            board.addMove(number, 'O');
        }
    }
    
    
    public void isWinner(String player) {
        if (player.equals(this.player1)) {
            player1Wins++;
        } else {
            player2Wins++;
        }
    }
    
    
    public boolean hasWon() {
        for (int i = 1; i <= 9; i++) {
            if ((board.getSymbol(i) == null) && (board.getSymbol(i) == board.getSymbol(i + 1)) && (board.getSymbol(i) == board.getSymbol(i + 2))) {
               return true;
            } else if ((board.getSymbol(i) == null) && (board.getSymbol(i) == board.getSymbol(i + 2)) && (board.getSymbol(i) == board.getSymbol(i + 4))) {
                return true;
            } else if ((board.getSymbol(i) == null) && (board.getSymbol(i) == board.getSymbol(i + 3)) && (board.getSymbol(i) == board.getSymbol(i + 6))) {
                return true;
            } else if ((board.getSymbol(i) == null) && (board.getSymbol(i) == board.getSymbol(i + 4)) && (board.getSymbol(i) == board.getSymbol(i + 8))) {
                return true;
            } else {
                return false;
            }
        }
    }
}