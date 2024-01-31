import java.util.Scanner;

public class Shop {
    private Arrowhead arrowhead = Arrowhead.STEEL;
    private Fletching fletching = Fletching.PLASTIC;
    
    private Scanner scanner;
    private Arrow arrow;
    
    public Shop() {
        this.scanner = new Scanner(System.in);
    }
    
    
    public void start() {
        greetCustomer();
        displayCustomMenu();
        createCustomArrow();
        displayOrder();
        displayCost();
    }
    
    
    public void greetCustomer() {
        System.out.println(ANSI.CYAN + "Hi, my name is Vin. Welcome to my shop!");
    }
    
    
    public void displayCustomMenu() {
        System.out.println(ANSI.GREEN + "\nCUSTOM OPTIONS\n----------------------------");
        
        System.out.println("Arrowhead: ");
        Arrowhead.STEEL.printArrowheadTypes();
        
        System.out.println("\nFletching: ");
        Fletching.PLASTIC.printFletchingTypes();
        
        
        System.out.println("----------------------------\n" + ANSI.RESET);
    }
    
    
    public void createCustomArrow() {
        Arrowhead chosenArrowhead = chooseArrowhead();
        Fletching chosenFletching = chooseFletching();
        int chosenLength = chooseLength();
        
        arrow = new Arrow(chosenArrowhead, chosenFletching, chosenLength);
    }
        
        
    public Arrowhead chooseArrowhead() {
        System.out.println(ANSI.CYAN + "Which type of Arrowhead do you want?" + ANSI.RESET);
        String arrowheadChoice = "";
        boolean valid = false;
        
        do {
            try{
                arrowheadChoice = scanner.nextLine();
                Arrowhead chosenArrowhead = Arrowhead.valueOf(arrowheadChoice.toUpperCase()); 
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(ANSI.RED + "Please choose one of the available options." + ANSI.RESET);
            }
        } while (!valid);
        
        return Arrowhead.valueOf(arrowheadChoice.toUpperCase());   
    }
    
    
    public Fletching chooseFletching() {
        System.out.println(ANSI.CYAN + "\nWhich type of fletching do you want?" + ANSI.RESET);
        String fletchingChoice = "";
        boolean valid = false;
         
        do {
            try {
                fletchingChoice = scanner.nextLine();
                Fletching chosenFletching = Fletching.valueOf(fletchingChoice.toUpperCase().trim().replaceAll(" ", "_"));
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(ANSI.RED + "Please choose one of the available options." + ANSI.RESET);
            }
        } while (!valid);
        
        return Fletching.valueOf(fletchingChoice.toUpperCase().trim().replaceAll(" ", "_"));   
    }
    
    
    public int chooseLength() {
        do {
            System.out.println(ANSI.CYAN + "\nWhat length do you want? Please pick a length between 60 and 100 cm." + ANSI.RESET);
            if (scanner.hasNextInt()) {
                int number = Integer.parseInt(scanner.nextLine());
                if (number >= 60 && number <= 100) {
                    return number;
                } else {
                    System.out.println(ANSI.RED + "Please choose a valid length." + ANSI.RESET);
                }
            } else {
                scanner.nextLine();
                System.out.println(ANSI.RED + "That is not a number." + ANSI.RESET);
            }   
        } while (true);
    }
    
    
    public void displayOrder() {
        System.out.println(ANSI.YELLOW + "\nYou ordered an arrow made from a " + arrow.getArrowhead().getName().toLowerCase() + 
        " arrowhead, " + arrow.getFletching().getName().toLowerCase() + " fletching, and a " + arrow.getLength() + " cm shaft." + ANSI.RESET); 
    }
    
    
    public void displayCost() {
        System.out.println(ANSI.YELLOW + "\nThis arrow costs " + arrow.getCost() + " gold." + ANSI.RESET);
    }
} 