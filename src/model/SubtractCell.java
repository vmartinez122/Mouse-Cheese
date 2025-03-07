package model;

import java.util.Random;

public class SubtractCell extends GameCell implements Questionable {
    private final int MIN_NUM = 1;
    private final int MAX_NUM = 3;
    private final int VALUE = 50;
    private int value;
    private Random rand = new Random();

    public SubtractCell() {
        super.content = "00";
    }

    public void setDiscovered() {
        super.setDiscovered();
        super.content = "--";
    }

    @Override
    public String getQuestion() {
        return "Insert a number between "+ MIN_NUM + " and " + MAX_NUM + ". Failing will loose you " + VALUE + " points:";
    }

    @Override
    public boolean submitAnswer(String answer){
        try {
            if (Integer.parseInt(answer) == rand.nextInt(MIN_NUM, MAX_NUM+1)) {
                System.out.println("Correct answer.");
                value = 0;
                return true;
            }
        }catch (Exception e){
            //Incorrect input
        }
        System.out.println("Wrong answer. -"+ VALUE+ " points.");
        value = -VALUE;
        return false;
    }

    /**
     * Deveulve el valor que añade esta celda, se podría implementar en la interfaz Questionable o
     * ser devuelto con submitAnswer.
     * @return valor de la resta;
     */
    public int getValue() {
        return value;
    }
}
