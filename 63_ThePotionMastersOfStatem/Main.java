import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine();
        ArrayList<Potion> createdPotions = new ArrayList<>();

        while (true) {
            while (true) {
                Potion currentPotion = stateMachine.getCurrentPotion();
                if (currentPotion.equals(Potion.RUINED_POTION)) {
                    System.out.println("You ruined the potion! You have to start over.");
                    break;
                }
                System.out.println("Current potion: " + currentPotion.name + "\n");

                if (currentPotion != Potion.WATER) {
                    int completeOrContinue = askChoice("""
                        What do you want to do?
                        1. complete the potion
                        2. add another ingredient?""", 2);
                    if (completeOrContinue == 1) {
                        createdPotions.add(currentPotion);
                        break;
                    }
                }

                printIngredientOptions();
                int ingredientChoice = askChoice("Which ingredient do you want to add? (Enter the number): ", Ingredient.values().length + 1);
                Ingredient ingredientToAdd = Ingredient.values()[ingredientChoice -1];
                System.out.println();
                stateMachine.addIngredient(ingredientToAdd);
            }

            stateMachine.startOver();
            printCreatedPotions(createdPotions);
            int createAnotherPotion = askChoice("""
                    Do you want to create another potion?
                    1. yes
                    2. no""", 2);
            if (createAnotherPotion == 2) {
                break;
            }
        }
    }

    private static void printIngredientOptions() {
        StringBuilder bldr = new StringBuilder("Ingredient options:\n");
        for (Ingredient ingredient : Ingredient.values()) {
            bldr.append((ingredient.ordinal() + 1)).append(" - ").append(ingredient.name);
            bldr.append("\n");
        }
        System.out.println(bldr);
    }

    private static int askChoice(String text, int max) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(text);
            if (scanner.hasNextInt()) {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Please choose one of the options.");
                }
            } else {
                System.out.println("Please enter the number before the option.");
                scanner.nextLine();
            }
        } while (true);
    }

    private static void printCreatedPotions(ArrayList<Potion> createdPotions) {
        System.out.println("\nYour potions:");
        for (Potion potion : createdPotions) {
            System.out.println("- " + potion.name);
        }
        System.out.println();
    }
}
