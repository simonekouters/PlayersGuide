public class Soup {
    private Type type = Type.SOUP;
    private Ingredient ingredient = Ingredient.MUSHROOM;
    private Seasoning seasoning = Seasoning.SPICY;
    
    public Soup(Type type, Ingredient ingredient, Seasoning seasoning) {
        this.type = type;
        this.ingredient = ingredient;
        this.seasoning = seasoning;
    }
    
    
    public String toString() {
        return seasoning.getName() + " " + ingredient.getName() + " " + type.getName();
    }
}