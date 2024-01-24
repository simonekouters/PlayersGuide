public class InventoryItem {
    private double weight;
    private double volume;

    public InventoryItem(double weight, double volume) {
        this.weight = weight;
        this.volume = volume;
    }


    public double getWeight() {
        return this.weight;
    }
    
    
    public double getVolume() {
        return this.volume;
    }
}
