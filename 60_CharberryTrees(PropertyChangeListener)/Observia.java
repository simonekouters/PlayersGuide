import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

class Observia {
    public static void main(String[] args ) {
      CharberryTree tree = new CharberryTree();
      Harvester harvester = new Harvester();
      Notifier notifier = new Notifier(tree, harvester);

      tree.addPropertyChangeListener(notifier);

    while (true) {
      tree.maybeGrow();
    }
  }
}


// CharberryTree is an observable
class CharberryTree {
  private final Random random = new Random();
  private boolean ripe = false;
  // An observable must have a PropertyChangeSupport instance
  private final PropertyChangeSupport support;

  public CharberryTree() {
    this.support = new PropertyChangeSupport(this);
  }

  public void maybeGrow() {
    // Only a tiny chance of ripening each time, but we try a lot!
    if (random.nextDouble() < 0.00000001 && !ripe) {
        ripe = true;
        // Sends a notification to the Notifier when the property ripe changes from false to true
        support.firePropertyChange("ripe", false, true);
    }
  }

  public void harvestCharberry() {
    ripe = false;
  }

  public void addPropertyChangeListener(PropertyChangeListener pcl) {
    // Method to add a PropertyChangeListener (in this case a Notifier)
    support.addPropertyChangeListener(pcl);
  }
}


// Notifier is an observer, so it should implement PropertyChangeListener
class Notifier implements PropertyChangeListener {
  private final CharberryTree tree;
  private final Harvester harvester;

  public Notifier(CharberryTree charberryTree, Harvester harvester) {
    this.tree = charberryTree;
    this.harvester = harvester;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    // When there's a propertyChange, look at the new value and check if it's equal to true
    if (evt.getNewValue().equals(true)) {
      System.out.println("A charberry fruit has ripened!");
      harvester.harvest(tree);
    }
  }
}


class Harvester {
  private int amountOfFruitsHarvested;

  public void harvest(CharberryTree tree) {
    tree.harvestCharberry();
    amountOfFruitsHarvested++;
    System.out.println("Amount of charberry fruits harvested: " + amountOfFruitsHarvested);
  }
}





