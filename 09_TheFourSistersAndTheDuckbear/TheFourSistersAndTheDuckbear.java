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

        /* The duckbear gets more eggs than the sisters when the number of eggs is: 
        - 1, 2, 3 - because when there's less then 4 there's not enough for the sisters and everything goes to the duckbear
-       - 6 - because 6 % 4 = 2, so the sisters get 1 egg and the duckbear 2
        - 7 - because 7 % 4 = 3, so the sisters get 1 egg and the duckbear 3
        - 11 - because 11 / 4 = 2.75 and 11 % 4 = 3, so the sisters get 2 eggs and the duckbear 3 
        - For every number above 11 the sisters will always get more eggs than the duckbear 
        */
    }
}



