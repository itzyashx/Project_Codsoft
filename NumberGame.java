import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int totalAttempts = 0;
        int totalScore = 0;

        while (true) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            rounds++;
            System.out.println("Round " + rounds + " started! Guess a number between 1 and 100.");

            while (true) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You got it in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    // Score is inversely proportional to attempts (max 100 points, minimum 10)
                    int roundScore = Math.max(100 - (attempts * 10), 10);
                    totalScore += roundScore;
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game Over! You played " + rounds + " rounds.");
        System.out.println("Total attempts: " + totalAttempts);
        double averageAttempts = (double) totalAttempts / rounds;
        System.out.println("Average attempts per round: " + averageAttempts);
        System.out.println("Total Score: " + totalScore);
        scanner.close();
    }
}