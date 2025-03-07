package model;

import java.util.Random;

public class ScoreCell extends GameCell {
    private int value;
    private final int[] SCORES = {10, 20, 30} ;

    public ScoreCell() {
        Random rand = new Random();
        int generate = rand.nextInt(0, SCORES.length);
        this.value = SCORES[generate]; //Asigna un valor aleatorio a la celda
        super.content = "00";
        //content = Integer.toString(score);
    }

    @Override
    public void setDiscovered() {
        super.setDiscovered();
        super.content = "·.";
    }

    public int getValue() {
        return value;
    }
}
