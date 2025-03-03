public class SumCell implements Questionable{
    @Override
    public String getQuestion() {
        return "Pregunta suma";
    }

    @Override
    public boolean submitAnswer(String answer) {
        return false;
    }
}
