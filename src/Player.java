import java.util.Scanner;

/**
 * Created by Megan on 4/21/2017.
 */
public abstract class Player {

    public abstract Options generateOpponentChoice();

    public abstract String getPlayerName();

    public static Player selectOpponent() {
        Scanner scan = new Scanner(System.in);
        String opponentName = "";
        Player opponent = null;

        do {
            System.out.println("Please select your opponent. Do you want to face Misty or Ash?");
            opponentName = scan.nextLine();
            if (opponentName.equalsIgnoreCase("Misty")) {
                opponent = new RandomPlayer();
            } else if (opponentName.equalsIgnoreCase("Ash")) {
                opponent = new RockPlayer();
            } else System.out.println("That is not a valid selection.");
        } while (opponent == null);

        return opponent;
    }
}
