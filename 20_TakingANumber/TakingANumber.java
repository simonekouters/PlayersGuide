import java.util.Scanner;

public class TakingANumber {

    public static void main(String[] args) {
        
        askForNumber("Enter a number:");
        
        askForNumberInRange("Enter a number between 1 and 100", 1, 100);
    }
    
    public static int askForNumber(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        
        int number = Integer.parseInt(scanner.nextLine());
        return number;
    }
    
    
    public static int askForNumberInRange(String text, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int number;
        
        do {
            System.out.println(text);
            number = Integer.parseInt(scanner.nextLine());
        } while (number < min || number > max);
        
        return number;
    }
}