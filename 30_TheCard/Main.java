public class Main {
    public static void main(String[] args) {
		
        createDeck();
    }


	public static void createDeck() {
        for (Card.Color color : Card.Color.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card card = new Card(color, rank);
                System.out.println(card);
            }
        }
    }
}