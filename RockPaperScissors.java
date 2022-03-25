import java.util.Scanner;

/**
 * The RockPaperScissors program implements an application that
 * asks the user to choose rock, paper, or scissors, then
 * generates a random selection and tells the user if they
 * have won, lost, or tied.
 *
 * @author  Ina Tolo
 * @version 1.0
 * @since   2022-3-18
 */

class RockPaperScissors {
    /**
     * Declaring constant for ROCK.
     */
    private static final int ROCK = 3;
    /**
     * Declaring constant for PAPER.
     */
    private static final int PAPER = 2;
    /**
     * Declaring constant for SCISSORS.
     */
    private static final int SCISSORS = 1;

    /**
     * Determines results of game.
     * 
     * @param choice is only being accepted
     * @return results to main function
     */
    public static String determineResults(int choice, int randomNumber) {
        // declaring variables
        String result = "";

        if (choice == randomNumber) {
            result = "Tie Game!";
            return result;
        } else if (choice == ROCK && randomNumber == PAPER) {
            result = "You lose.";
            return result;
        } else if (choice == PAPER && randomNumber == ROCK) {
            result = "You win!";
            return result;
        } else if (choice == PAPER && randomNumber == SCISSORS) {
            result = "You lose.";
            return result;
        } else {
            result = "You win!";
            return result;
        }
    }

    /**
     * Declaring constant for the random number
     */
    public static void main(String[] args) {
        // declaring variables
        final Scanner sc = new Scanner(System.in);
        String choiceString = "";
        int choiceIntUser = 0;
        String resultUser;
        final int randomNumberComp = (int) (Math.random() * (ROCK - SCISSORS + 1) + SCISSORS);

        System.out.println("Today you will be playing a game of rock, paper, scissors!");
        System.out.println("Your options are 1: rock, 2: paper, or 3: scissors.");
        System.out.println();
        
        while (choiceIntUser != randomNumberComp) {
            // gets one of the choices from the user
            System.out.print("Enter one of the above choices: ");
            choiceString = sc.nextLine();
    
            try {
                choiceIntUser = Integer.parseInt(choiceString);
                
                if (choiceIntUser >= SCISSORS && choiceIntUser <= ROCK) {
                    resultUser = determineResults(choiceIntUser, randomNumberComp);
                    
                    System.out.println("The computer chose " + randomNumberComp);
                    System.out.println(resultUser + "\n");
                } else {
                    System.out.println("This is not a valid choice!");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println("Invalid string option!");
            }
        }
        
    }
}
