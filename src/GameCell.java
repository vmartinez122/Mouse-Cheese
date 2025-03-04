public abstract class GameCell {
    private boolean isDiscovered;
    protected String content;

    protected GameCell(){
        this.content = "00";
        this.isDiscovered = false;
    }
    protected GameCell(String content){
        this.content = content;
        this.isDiscovered = false;
    }

    public boolean isDiscovered() {
        return isDiscovered;
    }

    public void setDiscovered() {
        setDiscovered("·.");
    }
    public void setDiscovered(String content) {
        this.content = content;
        isDiscovered = true;
    }

    @Override
    public String toString() {
        return  content;
    }
}
