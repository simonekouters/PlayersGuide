import java.util.Scanner;

public class TheFourSistersAndTheDuckbear {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many chocolate eggs were gathered today?");

        int eggs = Integer.parseInt(scanner.nextLine());
        int eggsForEachSister = eggs / 4;
        int eggsForDuckbear = eggs % 4;
		
		System.out.println();
        System.out.println("Eggs for each sister: " + eggsForEachSister);
        System.out.println("Eggs for the duckbear: " + eggsForDuckbear);

        // The duckbear gets more eggs than the sisters when the number of eggs is 0, 1, 2, 3, 6 or 11.
    }
}



