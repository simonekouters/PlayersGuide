import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
		
		System.out.println("Your password must: ");
			System.out.println("1. Be at least 6 letters and no more than 13 letters in length");
			System.out.println("2. Contain at least one uppercase letter");
			System.out.println("3. Contain at least one lowercase letter");
			System.out.println("4. Contain at least one number");
			System.out.println("5. NOT contain a capital T or and ampersand (&)");

        while (true) {
            System.out.print("\nEnter your password: ");
            String password = scanner.nextLine();
			
            PasswordValidator validator = new PasswordValidator(password);
            System.out.println(validator.validate());
        }
    }
}