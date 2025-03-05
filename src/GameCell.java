public abstract class GameCell {
    private boolean isDiscovered;
    protected String content;
    private int x;
    private int y;

    protected GameCell(int x, int y){
        this("00",x,y);
    }
    protected GameCell(String content,int x, int y){
        this.x = x;
        this.y = y;
        this.content = content;
        this.isDiscovered = false;
    }

    public boolean isDiscovered() {
        return isDiscovered;
    }

    public void setDiscovered() {
        setDiscovered("·.");
    }

    public boolean isMouse(int mouse_x,int mouse_y) {
        return x == mouse_x && y == mouse_y;
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
