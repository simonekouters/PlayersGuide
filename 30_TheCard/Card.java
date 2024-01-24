public class Card {

    enum Color {
        RED("Red"), GREEN("Green"), BLUE("Blue"), YELLOW("Yellow");

        public final String name;
        private Color(String name) {
            this.name = name;
        }
    }
	
	
    enum Rank {
        ONE("One"), TWO("Two"), THREE("Three"), FOUR("Four"), FIVE("Five"),
        SIX("Six"), SEVEN("Seven"), EIGHT("Eight"), NINE("Nine"), TEN("Ten"),
        DOLLAR("Dollar"), PERCENT("Percent"), CIRCUMFLEX("Circumflex"), AMPERSAND("Ampersand");

        public final String name;
        private Rank(String name) {
            this.name = name;
        }
    }
    
    private Color color = Color.RED;
    private Rank rank = Rank.ONE;


    public Card (Color color, Rank rank) {
        this.color = color;
        this.rank = rank;
    }


    public String cardType(Card card) {
        if (Card.this.rank.equals(Rank.DOLLAR) || Card.this.rank.equals(Rank.PERCENT)
        || Card.this.rank.equals(Rank.CIRCUMFLEX) || Card.this.rank.equals(Rank.AMPERSAND)) {
            return "the card is a symbol card";
        } else {
            return "the card is a number card";
        }
    }


    public String toString() {
        return "The " + this.color.name + " " + this.rank.name;
    }
}
