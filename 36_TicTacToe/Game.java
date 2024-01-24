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
        if ((board.getSymbol(7) != null) && (board.getSymbol(7) == board.getSymbol(8)) && (board.getSymbol(8) == board.getSymbol(9))) {
            return true;
        } else if ((board.getSymbol(4) != null) && (board.getSymbol(4) == board.getSymbol(5)) && (board.getSymbol(5) == board.getSymbol(6))) {
            return true;
        } else if ((board.getSymbol(1) != null) && (board.getSymbol(1) == board.getSymbol(2)) && (board.getSymbol(2) == board.getSymbol(3))) {
            return true;
        } else if ((board.getSymbol(7) != null) && (board.getSymbol(7) == board.getSymbol(4)) && (board.getSymbol(4) == board.getSymbol(1))) {
            return true;
        } else if ((board.getSymbol(8) != null) && (board.getSymbol(8) == board.getSymbol(5)) && (board.getSymbol(5) == board.getSymbol(2))) {
            return true;
        } else if ((board.getSymbol(9) != null) && (board.getSymbol(9) == board.getSymbol(6)) && (board.getSymbol(6) == board.getSymbol(3))) {
            return true;
        } else if ((board.getSymbol(7) != null) && (board.getSymbol(7) == board.getSymbol(5)) && (board.getSymbol(5) == board.getSymbol(3))) {
            return true;
        } else if ((board.getSymbol(1) != null) && (board.getSymbol(1) == board.getSymbol(5)) && (board.getSymbol(5) == board.getSymbol(9))) {
            return true;
        } else {
            return false;
        }
    }
}