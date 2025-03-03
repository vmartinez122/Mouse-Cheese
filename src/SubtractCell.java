public class SubtractCell implements Questionable {
    @Override
    public String getQuestion() {
        return "Pregunta resta";
    }

    @Override
    public boolean submitAnswer(String answer) {
        return false;
    }
}
