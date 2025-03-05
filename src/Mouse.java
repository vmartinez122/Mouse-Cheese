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

    //Could return boolean
    public void mouseMove(String direction){
        switch (direction){
            case "w":
                this.y--;
                break;
            case "a":
                this.x--;
                break;
            case "s":
                this.y++;
                break;
            case "d":
                this.x++;
                break;
        }
    }

}
