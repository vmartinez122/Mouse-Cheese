package model;

public class SumCell extends GameCell implements Questionable{
    private final int VALUE = 50;
    private int value;
    private final String[] ANSWERS = {"IntelliJ", "Eclipse", "NetBeans", "BlueJ", "jGRASP", "Codenvy"} ;

    public SumCell() {
        super.content = "00";
    }

    public void setDiscovered() {
        super.setDiscovered();
        super.content = "++";
    }

    @Override
    public String getQuestion() {
        return "To win " + VALUE + " points. Name an IDE for coding in java:";
    }

    @Override
    public boolean submitAnswer(String answer) {
        for (String a : ANSWERS){
            if (a.equalsIgnoreCase(answer)){
                value = VALUE;
                System.out.println("Correct answer. +"+ VALUE+ " points." );
                return true;
            }
        }
        value = 0;
        System.out.println("Incorrect answer.");
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
