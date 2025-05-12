import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    private static final int UPPER_BOUND = 100;
    private static final int ROCK_BOUND = 33;
    private static final int PAPER_BOUND = 67;

    public static void main(String[] args) {
        Random random = new Random();
        int computerChoice = random.nextInt(UPPER_BOUND) + 1;

        String computerMove;
        if (computerChoice <= ROCK_BOUND) {
            computerMove = "r";
        } else if (computerChoice <= PAPER_BOUND) {
            computerMove = "p";
        } else {
            computerMove = "s";
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter rock(r), paper(p), or scissors(s): ");
            String userMove = scanner.nextLine().toLowerCase();

            if (isValidMove(userMove)) {
                int result = game(userMove, computerMove);

                System.out.println("Computer chose " + getMoveName(computerMove));
                if (result == 1) {
                    System.out.println("You won the game!");
                } else if (result == -1) {
                    System.out.println("You lost the game.");
                } else {
                    System.out.println("The game is a draw.");
                }
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid choice.");
            }
        }
        scanner.close();
    }

    private static boolean isValidMove(String move) {
        return move.equals("r") || move.equals("p") || move.equals("s");
    }

    private static String getMoveName(String move) {
        return move.equals("r") ? "Rock" :
               move.equals("p") ? "Paper" : "Scissors";
    }

    public static int game(String userMove, String computerMove) {
        if ((userMove.equals("r") && computerMove.equals("s")) ||
            (userMove.equals("s") && computerMove.equals("p")) ||
            (userMove.equals("p") && computerMove.equals("r"))) {
            return 1; // User wins
        } else if (userMove.equals(computerMove)) {
            return 0; // Draw
        } else {
            return -1; // User loses
        }
    }
}
