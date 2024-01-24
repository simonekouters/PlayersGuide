import java.util.Scanner;

public class Shop {

    private Type type = Type.SOUP;
    private Ingredient ingredient = Ingredient.MUSHROOM;
    private Seasoning seasoning = Seasoning.SPICY;
	
	private Scanner scanner;
	private Soup soup;

    public Shop() {
		this.scanner = new Scanner(System.in);
    }
	
	
	public void start() {
		displayMenu();
		order();
		displayOrder();
	}
    
	
	public void displayMenu() {
		System.out.println("MENU\n----------------------------");
		
        System.out.println("Food Type: "); 
		Type.SOUP.printTypes();
		
        System.out.println("\nMain Ingredient: ");
		Ingredient.MUSHROOM.printIngredients();
		
        System.out.println("\nSeasoning: ");
		Seasoning.SPICY.printSeasonings();
		
		System.out.println("----------------------------\n");
	}
	
	
	public void order () {
		System.out.print("Pick a type of food from the menu: ");
		Type type = Type.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Pick a main ingredient from the menu: ");
        Ingredient ingredient = Ingredient.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Pick a seasoning from the menu: ");
        Seasoning seasoning = Seasoning.valueOf(scanner.nextLine().toUpperCase());

        soup = new Soup(type, ingredient, seasoning);
	}
	
	
	public void displayOrder() {
		System.out.println();
		System.out.println("You ordered: " + this.soup);
	}
}
