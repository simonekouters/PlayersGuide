public enum Fletching {
    PLASTIC("Plastic", 10), 
    TURKEYFEATHERS("Turkey feathers", 5), 
    GOOSEFEATHERS("Goose feathers", 3);

    private final String name;
    private final int cost;
        
    Fletching (String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
    
    
    public String getName() {
        return this.name;
    }
        
        
    public int getCost() {
        return this.cost;
    }
    
    
    public String toString() {
        return "- " + this.name;
    }
    
    
    public void printFletchingTypes() {
        for (Fletching fletching : Fletching.values()) {
            System.out.println(fletching.toString());
        }
    }
}