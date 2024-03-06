import java.io.*;
import java.util.Scanner;

public class TheLongGame {
    private static int score = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String name = askName(scanner);

        File file = new File(name + ".txt");
        checkIfFileExists(file);

        playGame(scanner);
        saveScoreToFile(file);
    }

    private static String askName(Scanner scanner) {
        System.out.print("Enter your name: ");
        return scanner.nextLine().trim().toLowerCase();
    }

    private static void checkIfFileExists(File file) throws IOException {
        if (file.isFile()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            score = Integer.parseInt(br.readLine());
            System.out.println("Your previous score: " + score);
        }
    }

    private static void playGame(Scanner scanner) {
        while (true) {
            System.out.println("Type your text and hit Enter to save. Type 'IO' to end the game.");
            String input = scanner.nextLine();
            score += input.length();
            System.out.println("Score: " + score);

            if (input.equals("IO")) {
                break;
            }
        }
    }

    private static void saveScoreToFile(File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.print(score);
        writer.close();
    }
}

