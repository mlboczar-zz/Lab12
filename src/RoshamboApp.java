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

        Player opponent = Player.selectOpponent();
        System.out.println("You will be facing " + opponent.getPlayerName() + " in your Roshambo battle.");

        int counterPlayer = 0;
        int counterOpponent = 0;
        String keepGoing;


        do {
            //Display prompt for user selection and get user input
            Options playerChoice = CalculateWinner.userChoice();
            System.out.println("You have chosen " + playerChoice + ".");

            //Generate opponents choice
            Options opponentChoice = opponent.generateOpponentChoice();

            //Display match results
            System.out.println(opponent.getPlayerName() + " has chosen " + opponentChoice + ".");
            int matchResult = CalculateWinner.calculateWinner(playerChoice, opponentChoice);
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
}
