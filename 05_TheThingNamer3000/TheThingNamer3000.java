import java.util.Scanner;

public class TheThingNamer3000 {
    public static void main(String[] args) {
        System.out.println("What kind of thing are we talking about?");

        Scanner input = new Scanner (System.in);

        // Stores what kind of thing it is
        String a = input.next();

        System.out.println("How would you describe it? Big? Azure? Tattered?");

        // Stores a characteristic of the thing */
        String b = input.next();

        // Stores "of Doom"
        String c = "of Doom";

        /* Stores the version number of the thing
         * Which is 3000 */
        String d = "3000";

        System.out.println("The " + b + " " + a + " " + c + " " + d + "!");

        /* The code can be made more understandable by giving
         * the variables names that describe what they do
         */

    }
}
