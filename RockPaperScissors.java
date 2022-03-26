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
    private static final int ROCK = 1;
    /**
     * Declaring constant for PAPER.
     */
    private static final int PAPER = 2;
    /**
     * Declaring constant for SCISSORS.
     */
    private static final int SCISSORS = 3;
    /**
     * Declaring constant for lose statement.
     */
    private static final String LOSE = "You lose.";
    /**
     * Declaring constant for win statement.
     */
    private static final String WIN = "You win!";

    /**
     * Determines results of game.
     *
     * @param choice is accepted
     * @param randomNumber is accepted
     * @return results to main function
     */
    public static String gameResults(int choice, int randomNumber) {
        // declaring variables
        String result = "";

        // deterimes tie or winner of game
        if (choice == randomNumber) {
            result = "Tie game.";
        } else if (choice == ROCK && randomNumber == PAPER) {
            result = LOSE;
        } else if (choice == PAPER && randomNumber == ROCK) {
            result = WIN;
        } else if (choice == ROCK && randomNumber == SCISSORS) {
            result = WIN;
        } else if (choice == SCISSORS && randomNumber == ROCK) {
            result = LOSE;
        } else if (choice == PAPER && randomNumber == SCISSORS) {
            result = LOSE;
        } else {
            result = WIN;
        }
        return result;
    }

    /**
     * Main entry into program.
     *
     * @param args nothing passed in
     */
    public static void main(String[] args) {
        // declaring variables
        final Scanner sc = new Scanner(System.in);
        String choiceString = "";
        String resultUser;
        int choiceUserInt;
        int tries = 0;
        int randomNumberComp;
        int gameCounter = 0;

        System.out.println("Today you will be playing a game of"
            + "rock, paper, scissors with the computer!");
        System.out.println("Your options are 1: rock, "
            + "2: paper, or 3: scissors.\n");

        while (gameCounter != 1) {
            // gets one of the specified choices from user
            System.out.print("Enter one of the above choices: ");
            choiceString = sc.nextLine();

            // generates random number corresponding to computer choice
            randomNumberComp =
                (int) (Math.random() * (SCISSORS - ROCK + 1) + ROCK);

            try {
                choiceUserInt = Integer.parseInt(choiceString);

                if (choiceUserInt >= ROCK && choiceUserInt <= SCISSORS) {

                    // calls function to determine tie game or a winner
                    resultUser =
                        gameResults(choiceUserInt, randomNumberComp);

                    System.out.println("The computer chose: "
                        + randomNumberComp);
                    System.out.println(resultUser + "\n");

                    tries++;

                    // checks if user has won in order to break loop
                    if (resultUser == WIN) {
                        System.out.println("It took you "
                            + tries + " tries to win!");
                        gameCounter++;
                    }
                } else {
                    System.out.println("This is not a valid choice!\n");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println("This cannot be accepted as a valid number.\n");
            }
        }
    }
}
