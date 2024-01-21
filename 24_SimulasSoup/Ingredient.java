public enum Ingredient {
    MUSHROOM("Mushroom"), 
	CHICKEN("Chicken"), 
	CARROT("Carrot"), 
	POTATO("Potato");

	private final String name;
	
	private Ingredient(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	
	public String toString() {
		return "- " + this.name;
	}
	
	
	public void printIngredients() {
		for (Ingredient ingredient : Ingredient.values()) {
			System.out.println(ingredient.toString());
		}
	}
}
