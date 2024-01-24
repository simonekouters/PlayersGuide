import java.util.ArrayList;
import java.util.List;

public class Pack {
    private List<InventoryItem> items;
	
    private int maxItems;
    private double maxWeight;
    private double maxVolume;

    public Pack(int maxItems, double maxWeight, double maxVolume) {
        this.items = new ArrayList<>();
		
        this.maxItems = maxItems;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
    }

    public boolean add(InventoryItem item) {
        if ((getItemCount() == this.maxItems) ||
                (getTotalWeight() + item.getWeight() > this.maxWeight) ||
                (getTotalVolume() + item.getVolume() > this.maxVolume)) {
            System.out.println("The item exceeds the limit of the pack");
            return false;
        }
        this.items.add(item);
        return true;
    }
	
	
    public boolean full() {
        if (getItemCount() == this.maxItems || getTotalWeight() == this.maxWeight || getTotalVolume() == this.maxVolume) {
            return true;
        }
        getStats();
		
        return false;
    }


    public int getItemCount() {
        return this.items.size();
    }


    public double getTotalWeight() {
        double sum = 0;
        for (InventoryItem item : this.items) {
            sum += item.getWeight();
        }
        return sum;
    }


    public double getTotalVolume() {
        double sum = 0;
        for (InventoryItem item : this.items) {
            sum += item.getVolume();
        }
        return sum;
    }
	
	
    public String getStats() {
        return "Item count: " + getItemCount() + "/" + this.maxItems +
                "\nWeight: " + getTotalWeight() + "/" + this.maxWeight +
                "\nVolume: " + getTotalVolume() + "/" + this.maxVolume + "\n";
    }


    @Override
    public String toString() {
        String printItems = "";
        for (InventoryItem item : this.items) {
            printItems += item + " ";
        }
        if (this.items.isEmpty()) {
            return "The pack is empty";
        }
        return "Pack containing: " + printItems;
    }
}
