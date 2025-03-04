public class Mouse {
    private String content;
    private int x;
    private int y;

    public Mouse(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isMouse(int x, int y){
        return this.x == x && this.y == y;
    }
}
