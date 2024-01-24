import java.util.Scanner;

public class UserInterface {
	
    private Scanner scanner;
    private int round;
    private int games;
	private Game game;
	private Board board;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.round = 1;
        this.games = 1;
		this.board = new Board();
    }
	
	
    public void start() {
		makeNewGame();
		
        while (this.games <= 5) {
            System.out.println("Round: " + this.games +"\n");
			
            playGame();
            board.clearBoard();
			
            System.out.println("");
			
            this.games++;
            this.round = 1;
        }
		
        System.out.println(game.getPlayer1() + " won " + game.getPlayer1Wins() + " times");
        System.out.println(game.getPlayer2() + " won " + game.getPlayer2Wins() + " times");
    }
	
	
	public void makeNewGame() {
		System.out.print("Player 1 (X), enter your name: ");
        String player1 = scanner.nextLine();
		
        System.out.print("Player 2 (O), enter your name: ");
        String player2 = scanner.nextLine();
		
        this.game = new Game(player1, player2, board);
	}
	
	
    public void playGame() {
        while (true) {
            String player = (this.round % 2 == 0) ? this.game.getPlayer2() : this.game.getPlayer1();
            System.out.println("It's " + player + "'s turn.");
			
            this.board.displayBoard();
			
            System.out.print("What square do you want to play in? (Squares correspond to number pad) ");
            move(player);
			
            System.out.println("");

            if (game.hasWon()) {
                board.displayBoard();
                System.out.println(player + " has won!");
                game.isWinner(player);
                break;
            }
			
            if (this.round == 9) {
                board.displayBoard();
                System.out.println("It's a tie!");
                break;
            }
            round++;
        }
    }
	
	
    public void move(String player) {
        int number = Integer.parseInt(scanner.nextLine());
        game.move(number, player);
    }
}
