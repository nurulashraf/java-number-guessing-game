package numberguessinggame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * A simple number guessing game where the user guesses a random number
 * within a specified range.
 */
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1; // Lower limit of the range
        int upperBound = 100; // Upper limit of the range
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int userGuess = 0;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between " + lowerBound + " and " + upperBound + ". Can you guess it?");

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            
            try {
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.close();
    }
}
