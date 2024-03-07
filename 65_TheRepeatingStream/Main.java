import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecentNumbers recentNumbers = new RecentNumbers();
        
        NumberGenerating numberGenerating = new NumberGenerating(recentNumbers);
        Thread numberGeneratingThread = new Thread(numberGenerating);
        numberGeneratingThread.start();
        
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                numberGenerating.stopThread();
                break;
            }
        }
    
        if (recentNumbers.lastTwoNumbersAreTheSame()) {
            System.out.println("You got it right!");
        } else {
            System.out.println("You got it wrong!");
        }
    }
}


