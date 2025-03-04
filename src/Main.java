import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Main program = new Main();
        program.start();
    }

    void start(){
        Mouse mouse = new Mouse(0, 0);
        Board board = new Board(mouse);
        board.showBoard();
    }


}