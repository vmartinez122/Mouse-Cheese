import java.util.Random;

public class ScoreCell extends GameCell {
    private String content;
    private int score;
    private final int[] SCORES = {10, 20, 30} ;

    public ScoreCell(int x, int y) {
        super(x,y);
        Random rand = new Random();
        int generate = rand.nextInt(0, SCORES.length);
        this.score = SCORES[generate]; //Asigna un valor aleatorio a la celda
        content = Integer.toString(score);
    }

    public int getScore() {
        return score;
    }
}
