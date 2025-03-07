package model;

public abstract class GameCell {
    private boolean isDiscovered;
    private int value;
    protected String content;

    public boolean isDiscovered() {
        return isDiscovered;
    }

    public void setDiscovered() {
        isDiscovered = true;
    }

    @Override
    public String toString() {
        return  content;
    }

    //NEW
    public int getValue() {
        return value;
    }
}
