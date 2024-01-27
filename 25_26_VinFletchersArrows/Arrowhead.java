public enum Arrowhead {
    STEEL("Steel", 10), 
    WOOD("Wood", 3), 
    OBSIDIAN("Obsidian", 5);
    
    private final String name;
    private final int cost;
        
    Arrowhead (String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
    
    
    public String getName() {
        return this.name;
    }
        
        
    public int getCost() {
        return this.cost;
    }
    
    
    @Override
    public String toString() {
        return "- " + this.name;
    }
    
    
    public void printArrowheadTypes() {
        for (Arrowhead arrowhead : Arrowhead.values()) {
            System.out.println(arrowhead.toString());
        }
    }
}
