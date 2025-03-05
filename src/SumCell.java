public class SumCell extends GameCell implements Questionable{

    public SumCell(int x, int y) {
        super("++",x,y);
    }

    @Override
    public void setDiscovered() {
        super.setDiscovered("++");
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
