package model;

public class SumCell extends GameCell implements Questionable{

    public SumCell() {
        super.content = "00";
    }

    public void setDiscovered() {
        super.setDiscovered();
        super.content = "++";
        System.out.println(getQuestion());
    }

    @Override
    public String getQuestion() {
        return "Pregunta suma";
    }

    @Override
    public boolean submitAnswer(String answer) {
        return false;
    }
}
