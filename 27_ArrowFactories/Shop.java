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
        String menuChoice = askMenuChoice();
        
        if (menuChoice.equals("standard")) { 
            displayStandardMenu();
            createStandardArrow();
        } else { 
            displayCustomMenu();
            createCustomArrow();
        }
        displayOrder();
        displayCost();
    }
    
    
    public void greetCustomer() {
        System.out.println(ANSI.CYAN + "Hi, my name is Vin. Welcome to my shop!\n");
        System.out.println("Are you looking to buy a standard or a custom arrow?" + ANSI.RESET);
    }
    
    
    public String askMenuChoice() {
        do {
            String input = scanner.nextLine();
            if (input.toLowerCase().equals("standard") || input.toLowerCase().equals("custom")) {
                return input;
            } else {
                System.out.println(ANSI.RED + "Please choose 'standard' or 'custom'." + ANSI.RESET); 
            }
        } while (true);
    }
    
    
    public void displayStandardMenu() {
        System.out.println(ANSI.GREEN + "\nSTANDARD OPTIONS\n------------------------------------------------------------------------------------------------");
        System.out.println("- The Elite Arrow, made from a steel arrowhead, plastic fletching, and a 95 cm shaft.");
        System.out.println("- The Beginner Arrow, made from a wood arrowhead, goose feathers fletching, and a 75 cm shaft.");
        System.out.println("- The Marksman Arrow, made from a steel arrowhead, goose feathers fletching, and a 65 cm shaft.");
        System.out.println("------------------------------------------------------------------------------------------------\n" + ANSI.RESET);
    }
    
    
    public void createStandardArrow() {
        String standardArrowChoice = chooseStandardArrow();
        
        if (standardArrowChoice.equals("elite")) {
            arrow = Arrow.createEliteArrow();
        } else if (standardArrowChoice.equals("beginner")) {
            arrow = Arrow.createBeginnerArrow();
        } else {
            arrow = Arrow.createMarksmanArrow();
        }
    }
    
    
    public String chooseStandardArrow() {
        System.out.println(ANSI.CYAN + "Do you want an 'elite', 'beginner' or 'marksman' arrow?" + ANSI.RESET);
        
        do {
            String input = scanner.nextLine();
            if (input.toLowerCase().equals("elite") || input.toLowerCase().equals("beginner") || input.toLowerCase().equals("marksman")) {
                return input;
            } else {
                System.out.println(ANSI.RED + "Please choose 'elite', 'beginner' or 'marksman'." + ANSI.RESET); 
            }
        } while (true);
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