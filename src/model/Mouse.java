package model;

public class Mouse {
    private int[] coords;
    private int score;

    public Mouse(int x, int y){
        this.coords = new int[]{x,y};
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    //Could return boolean
    public void mouseMove(String direction){
        switch (direction){
            case "w":
                this.coords[1]--;
                break;
            case "a":
                this.coords[0]--;
                break;
            case "s":
                this.coords[1]++;
                break;
            case "d":
                this.coords[0]++;
                break;
        }
    }

    public int[] getCoords(){
        return coords;
    }

}