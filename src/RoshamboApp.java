import java.util.Scanner;

/**
 * Created by Megan on 4/21/2017.
 */
public class RoshamboApp {

    public static void main(String[] args) {

        //Prompt user for name and opponent
        System.out.println("Let's play! What should I call you?");
        Scanner scan = new Scanner(System.in);
        String playerName = scan.nextLine();
        System.out.println("Welcome " + playerName + "!");

        Player opponent = selectOpponent();
        System.out.println("You will be facing " + opponent.getPlayerName() + " in your Roshambo battle.");

        int counterPlayer = 0;
        int counterOpponent = 0;
        String keepGoing;


        do {
            //Display prompt for user selection and get user input
            Options playerChoice = userChoice();
            System.out.println("You have chosen " + playerChoice + ".");

            //Generate opponents choice
            Options opponentChoice = opponent.generateOpponentChoice();

            //Display match results
            System.out.println(opponent.getPlayerName() + " has chosen " + opponentChoice + ".");
            int matchResult = calculateWinner(playerChoice, opponentChoice);
            if (matchResult == 1){
                System.out.println(playerName + " wins!");
                counterPlayer++;
            } else if (matchResult == -1) {
                System.out.println(opponent.getPlayerName() + " wins!");
                counterOpponent++;
            } else
                System.out.println("It's a tie!");

            //Display running total
            System.out.println(playerName + " has won " + counterPlayer + " games.");
            System.out.println(opponent.getPlayerName() + " has won " + counterOpponent + " games.");

            //Prompt the user to continue
            System.out.println("Would you like to keep going? y/n");
            keepGoing = scan.next();

        } while (keepGoing.equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!");


    }

    private static Options userChoice() {
        Scanner scan = new Scanner(System.in);
        String playerInput = "";
        Options playerChoice = null;

        do {
            System.out.println("Roshambo! Make your choice. Rock, paper, or scissors?");
            playerInput = scan.nextLine();
            if (playerInput.equalsIgnoreCase(Options.ROCK.toString())) {
                playerChoice = Options.ROCK;
            } else if (playerInput.equalsIgnoreCase(Options.PAPER.toString())) {
                playerChoice = Options.PAPER;
            } else if (playerInput.equalsIgnoreCase(Options.SCISSORS.toString())) {
                playerChoice = Options.SCISSORS;
            } else System.out.println("That is not a valid selection.");
        } while (playerChoice == null);

        return playerChoice;
    }

    private static Player selectOpponent() {
        Scanner scan = new Scanner(System.in);
        String opponentName = "";
        Player opponent = null;

        do {
            System.out.println("Please select your opponent. Do you want to face Misty or Ashe?");
            opponentName = scan.nextLine();
            if (opponentName.equalsIgnoreCase("Misty")) {
                opponent = new RandomPlayer();
            } else if (opponentName.equalsIgnoreCase("Ash")) {
                opponent = new RockPlayer();
            } else System.out.println("That is not a valid selection.");
        } while (opponent == null);

        return opponent;
    }

    private static int calculateWinner(Options playerChoice, Options opponentChoice) {
        switch (playerChoice) {
            case ROCK:
                switch (opponentChoice){
                    case ROCK:
                        return 0;
                    case PAPER:
                        return -1;
                    case SCISSORS:
                        return 1;
                }
            case PAPER:
                switch (opponentChoice){
                    case ROCK:
                        return 1;
                    case PAPER:
                        return 0;
                    case SCISSORS:
                        return -1;
                }
            case SCISSORS:
                switch (opponentChoice){
                    case ROCK:
                        return -1;
                    case PAPER:
                        return 1;
                    case SCISSORS:
                        return 0;
                }
        } return 0;         //should never be reached
    }
}
