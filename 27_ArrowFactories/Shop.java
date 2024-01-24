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
        
        //If user chooses standard arrow, they are only able to see the standard options and create a standard arrow
        if (menuChoice.equals("standard")) { 
            displayStandardMenu();
            createStandardArrow();
            //If user chooses standard arrow, they are only able to see the custom options and create a custom arrow
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
        String input = "";
        boolean valid = false;
        
        //Ask user for input until they choose one of the two options
        while (!valid) {
            input = scanner.nextLine();
            
            if (input.toLowerCase().equals("standard") || input.toLowerCase().equals("custom")) {
                valid = true;
            } else {
                System.out.println(ANSI.RED + "Please choose 'standard' or 'custom'." + ANSI.RESET); 
            }
        }
        return input;
    }
    
    
    public void displayStandardMenu() {
        System.out.println(ANSI.GREEN + "\nSTANDARD OPTIONS\n---------------------------------------------------------------------------------------");
        System.out.println("- The Elite Arrow, made from a steel arrowhead, plastic fletching, and a 95 cm shaft.");
        System.out.println("- The Beginner Arrow, made from a wood arrowhead, goose feathers fletching, and a 75 cm shaft.");
        System.out.println("- The Marksman Arrow, made from a steel arrowhead, goose feathers fletching, and a 65 cm shaft.");
        System.out.println("---------------------------------------------------------------------------------------\n" + ANSI.RESET);
    }
    
    
    public void createStandardArrow() {
        //Make sure the user input is valid before creating an arrow
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
        String input = "";
        boolean valid = false;
        
        System.out.println(ANSI.CYAN + "Do you want an 'elite', 'beginner' or 'marksman' arrow?" + ANSI.RESET);
        
        //Ask user for input until they choose one of the three options
        while (!valid) {
            input = scanner.nextLine();
            
            if (input.toLowerCase().equals("elite") || input.toLowerCase().equals("beginner") || input.toLowerCase().equals("marksman")) {
                valid = true;
            } else {
                System.out.println(ANSI.RED + "Please choose 'elite', 'beginner' or 'marksman'." + ANSI.RESET); 
            }
        }
        return input;
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
        String arrowheadChoice = "";
        boolean valid = false;
        
        System.out.println(ANSI.CYAN + "Which type of Arrowhead do you want?" + ANSI.RESET);
        
        //Ask user for input until they choose one of the three options 
        while (!valid) {
            arrowheadChoice = scanner.nextLine();
            
            try {
            Arrowhead chosenArrowhead = Arrowhead.valueOf(arrowheadChoice.toUpperCase()); 
            valid = true;
            
            } catch(IllegalArgumentException e) {
                System.out.println(ANSI.RED + "Please choose one of the available options." + ANSI.RESET);
            }
        }
        return Arrowhead.valueOf(arrowheadChoice.toUpperCase());    
    }
    
    
    public Fletching chooseFletching() {
        String fletchingChoice = "";
        boolean valid = false;
        
        System.out.println(ANSI.CYAN + "\nWhich type of fletching do you want?" + ANSI.RESET);
        
        //Ask user for input until they choose one of the three options 
        while (!valid) {
            fletchingChoice = scanner.nextLine();
            
            try {
            Fletching chosenFletching = Fletching.valueOf(fletchingChoice.toUpperCase().replaceAll(" ", ""));
            valid = true;
            
            } catch(IllegalArgumentException e) {
                System.out.println(ANSI.RED + "Please choose one of the available options." + ANSI.RESET);
            }
        }
        return Fletching.valueOf(fletchingChoice.toUpperCase().replaceAll(" ", ""));    
    }
    
    
    public int chooseLength() {
        String lengthChoice = "";
        boolean valid = false;
        
        System.out.println(ANSI.CYAN + "\nWhat length do you want? Please pick a length between 60 and 100 cm." + ANSI.RESET);
        
        //Validate that the user input is a number and is between 60 and 100 before returning the length
        while (!valid) {
            lengthChoice = scanner.nextLine(); 
            if(isANumber(lengthChoice) && lengthIsValid(lengthChoice)) {
                valid = true; 
            } 
        }
        int length = Integer.parseInt(lengthChoice);
        return length;
    }
    
    
    public boolean isANumber(String lengthChoice) {
        boolean isANumber = false;
        
        try {
                int length = Integer.parseInt(lengthChoice);
                isANumber = true;
            } catch(NumberFormatException e) {
                System.out.println(ANSI.RED + "That is not a number." + ANSI.RESET);
            }
        return isANumber;
    }
    
    
    public boolean lengthIsValid(String lengthChoice) {
        int length = Integer.parseInt(lengthChoice);
        
        if (length >= 60 && length <= 100) {
            return true;
        }
        
        System.out.println(ANSI.RED + "Please choose a valid length." + ANSI.RESET);
        return false;
    }
        
        public void displayOrder() {
        System.out.println(ANSI.YELLOW + "\nYou ordered an arrow made from a " + arrow.getArrowhead().getName().toLowerCase() + 
        " arrowhead, " + arrow.getFletching().getName().toLowerCase() + " fletching, and a " + arrow.getLength() + " cm shaft." + ANSI.RESET);
        
    }
    
    
    public void displayCost() {
        System.out.println(ANSI.YELLOW + "\nThis arrow costs " + arrow.getCost() + " gold." + ANSI.RESET);
    }
} 