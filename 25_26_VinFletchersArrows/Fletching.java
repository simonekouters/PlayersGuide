public enum Fletching {
    PLASTIC("Plastic", 10), 
    TURKEY_FEATHERS("Turkey feathers", 5), 
    GOOSE_FEATHERS("Goose feathers", 3);

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
    
    
    @Override
    public String toString() {
        return "- " + this.name;
    }
    
    
    public void printFletchingTypes() {
        for (Fletching fletching : Fletching.values()) {
            System.out.println(fletching.toString());
        }
    }
}