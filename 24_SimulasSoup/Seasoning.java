public enum Seasoning {
    SPICY("Spicy"), 
    SALTY("Salty"), 
    SWEET("Sweet");
    
    private final String name;
    
    private Seasoning(String name) {
        this.name = name;
    }

    
    public String getName() {
        return this.name;
    }
    
    
    @Override
    public String toString() {
        return "- " + this.name;
    }
    
    
    public void printSeasonings() {
        for (Seasoning seasoning : Seasoning.values()) {
            System.out.println(seasoning.toString());
        }
    }
}


