import java.util.Scanner;

/**
 * Created by Megan on 4/24/2017.
 */
public class CalculateWinner {

    public static Options userChoice() {
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



    public static int calculateWinner(Options playerChoice, Options opponentChoice) {
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
