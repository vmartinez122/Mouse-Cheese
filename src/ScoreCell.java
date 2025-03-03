import java.util.Arrays;
import java.util.Random;

public class ScoreCell extends GameCell {
    private int content;
    private int score;
    private final int[] SCORES = {10, 20, 30} ;

    public ScoreCell() {
        Random rand = new Random();
        int generate = rand.nextInt(0, SCORES.length);
        this.score = SCORES[generate]; //
        super.content = Integer.toString(score);
    }

    public int getScore() {
        return score;
    }
}
