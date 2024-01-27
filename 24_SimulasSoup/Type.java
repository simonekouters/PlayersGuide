public enum Type {
    SOUP("Soup"), 
    STEW("Stew"), 
    GUMBO("Gumbo");
    
    private final String name;
    
    private Type(String name) {
        this.name = name;
    }
    
    
    public String getName() {
        return this.name;
    }
    
    
    @Override
    public String toString() {
        return "- " + this.name;
    }
    
    
    public void printTypes() {
        for (Type type : Type.values()) {
            System.out.println(type.toString());
        }
    }
}
