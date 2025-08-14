package java_Development_Oasis_tasks;

import java.util.Scanner;

public class NumberGuessingGame_Task2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int round = 1;
        int score = 0;

        while (true) 
        {
            System.out.println("\n--- Round " + round + " ---");
            int points = playGame(scanner);
            score += points;

            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes"))
            {
                break;
            }

            round++;
        }

        System.out.println("Thanks for playing! Final Score: " + score);
    }

    public static int playGame(Scanner scanner) 
    {
        int numberToGuess = (int) (Math.random() * 100) + 1;
        int attempts = 0;
        int maxAttempts = 5;

        System.out.println("Guess the number between 1 and 100 (Max attempts: " + maxAttempts + ")");

        while (attempts < maxAttempts) 
        {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == numberToGuess)
            {
                System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                return (maxAttempts - attempts + 1) * 10; // More points for fewer attempts
            }
        
            else if (guess < numberToGuess) 	
            {
                System.out.println("Too low!");   
            }
            
            else 
            {
                System.out.println("Too high!");
            }
        }

        System.out.println("Sorry, you used all attempts! The number was: " + numberToGuess);
        return 0;
    }
}
