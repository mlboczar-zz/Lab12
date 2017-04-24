import java.util.Random;

/**
 * Created by Megan on 4/21/2017.
 */
public class RandomPlayer extends Player{
    private Random random = new Random();

    @Override
    public Options generateOpponentChoice() {
        int randomChoiceInt = random.nextInt(3);
        return Options.values()[randomChoiceInt];
    }

    @Override
    public String getPlayerName() {
        return "Misty";
    }
}
