import java.util.Scanner;

public class TheTriangleFarmer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is the triangle's base size? ");
        double base = Double.valueOf(scanner.nextLine());

        System.out.print("What is the triangle's height? ");
        double height = Double.valueOf(scanner.nextLine());
		
		double area = base * height;

        System.out.println("The area of the triangle is " + area);
    }
}