public class Arrow {
    private Arrowhead arrowhead = Arrowhead.STEEL;
    private Fletching fletching = Fletching.PLASTIC;
    private int length;
    private final float COST_PER_CENTIMETER; 

    public Arrow(Arrowhead arrowhead, Fletching fletching, int length) {
        this.arrowhead = arrowhead;
        this.fletching = fletching;
        this.length = length;
        this.COST_PER_CENTIMETER = 0.05f;
    }
    
    
    public Arrowhead getArrowhead() {
        return this.arrowhead;
    }
    
    
    public Fletching getFletching() {
        return this.fletching;
    }
    
    
    public int getLength() {
        return this.length;
    }
    
    
    public float getCost() {
        int arrowCost = this.arrowhead.getCost(); 
        
        int fletchingCost = this.fletching.getCost(); 
        
        float lengthCost = this.length * COST_PER_CENTIMETER;
        
        float totalCost = arrowCost + fletchingCost + lengthCost;
        
        return totalCost;
    }
}
