import java.util.Random;

public class Observia {
  public static void main(String[] args) {
    CharberryTree tree = new CharberryTree();
    Harvester harvester = new Harvester();
    Notifier notifier = new Notifier(harvester);

    // Notifier is added as an observer
    tree.addObserver(notifier);

    while (true) {
      tree.maybeGrow();
      notifier.handle(tree);
    }
  }
}

/* This interface will be implemented by classes (int this case only the Notifier)
that want to listen for events related to the CharberryTree
 */
interface Observer {
  void handle(CharberryTree tree);
}

// CharberryTree is an observable
class CharberryTree {
  private final Random random = new Random();
  private boolean ripe = false;
  private Observer observer;

  public void addObserver(Observer observer) {
    this.observer = observer;
  }

  public void maybeGrow() {
    // Only a tiny chance of ripening each time, but we try a lot!
    if (random.nextDouble() < 0.00000001 && !ripe) {
      ripe = true;
      // Notify the observer (Notifier) when the tree is ripe
      observer.handle(this);
    }
  }

  public boolean isRipe() {
    return ripe;
  }

  public void setRipe(boolean ripe) {
    this.ripe = ripe;
  }
}


// Notifier is an observer
class Notifier implements Observer {
  private final Harvester harvester;

  public Notifier(Harvester harvester) {
    this.harvester = harvester;
  }

  @Override
  public void handle(CharberryTree tree) {
    /* I don't understand why it doesn't work without checking if it's ripe,
    because the handle method only gets called when a fruit is ripe?
     */
    if (tree.isRipe()) {
      System.out.println("A charberry fruit has ripened!");
      harvester.harvest(tree);
    }
  }
}


class Harvester {
  private int amountOfFruitsHarvested;

  public void harvest(CharberryTree tree) {
    tree.setRipe(false);
    amountOfFruitsHarvested++;
    System.out.println("Amount of charberry fruits harvested: " + amountOfFruitsHarvested);
  }
}



