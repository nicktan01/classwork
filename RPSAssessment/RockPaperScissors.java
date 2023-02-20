import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numRounds;
        int ties = 0, userWins = 0, computerWins = 0;

        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("How many rounds would you like to play (1-10)");
        numRounds = sc.nextInt();

        // Validate input
        if (numRounds < 1 || numRounds > 10) {
            System.out.println("Invalid number of rounds. Please try again.");
            return;
        }

        for(int i = 1; i <= numRounds; i++){
            System.out.println("Round " + i + ":");
            System.out.println("Enter your choice (1 = Rock, 2 = Paper, 3 = Scissors): ");
            int userChoice = sc.nextInt();
            int computerChoice = rand.nextInt(3) + 1;

            // Determine winner of round
            int winner = getWinner(userChoice, computerChoice);
            if (winner == 0){
                System.out.println("It's a tie!");
                ties++;
            }
            else if (winner == 1){
                System.out.println("You win!");
                userWins++;
            }
            else {
                System.out.println("Computer wins!");
                computerWins++;
            }
        }

        //Print final results
        System.out.println("Game over! Results:");
        System.out.println("Ties: " + ties);
        System.out.println("User wins: " + userWins);
        System.out.println("Computer wins: " + computerWins);

        //Determine overall winner
        if (userWins > computerWins) {
            System.out.println("You win the game!");
        }
        else if (userWins < computerWins) {
            System.out.println("Computer wins the game!");
        }
        else {
            System.out.println("The game is a tie!");
        }

        // Ask if user wants to play again
        System.out.println("Do you want to play again (Y/N)?");
        String playAgain = sc.next();
        if (playAgain.equalsIgnoreCase("Y")) {
            main(args); //start over
        }
        else {
            System.out.println("Thanks for playing!");
        }
    }

    //Helper to determine winner of a round
    private static int getWinner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return 0; // tie
        }
        else if (userChoice == 1 && computerChoice == 3 || userChoice == 2 && computerChoice == 1 || userChoice == 3 && computerChoice ==2) {
            return 1; //user wins
        }
        else {
            return -1; // cpu wins
        }
    }
}