import java.util.Random;

public class SubtractCell extends GameCell implements Questionable {
    private final Integer MIN_NUM = 1;
    private final Integer MAX_NUM = 3;
    private final Integer VALUE = 50;
    private Random rand = new Random();

    public SubtractCell(int x, int y) {
        super("--",x,y);
    }

    @Override
    public void setDiscovered() {
        super.setDiscovered("--");
        System.out.println(getQuestion());
    }
    @Override
    public String getQuestion() {
        return "Inserte un num del "+ MIN_NUM + " al " + MAX_NUM + ". Si no lo acierta, perderá " + VALUE + " puntos.";
    }

    @Override
    public boolean submitAnswer(String answer){
        try {
            if (Integer.parseInt(answer) == rand.nextInt(MIN_NUM, MAX_NUM+1)){
                return true;
            }

        }catch (Exception e){

        }
        return false;
    }
}
