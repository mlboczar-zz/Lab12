/**
 * Created by Megan on 4/21/2017.
 */
public class RockPlayer extends Player{

    //I gotta rock...
    @Override
    public Options generateOpponentChoice() {
        return Options.ROCK;
    }

    @Override
    public String getPlayerName() {
        return "Ash";
    }
}
