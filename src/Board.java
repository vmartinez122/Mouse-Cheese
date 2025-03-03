import java.util.ArrayList;
import java.util.Random;

public class Board {
    private GameCell[][] board;
    private static final int SIZE = 4;
    private Random rand = new Random();

    public Board() {
        board = new GameCell[SIZE][SIZE];
        createBoard();
    }
    private void createBoard(){
        //board[0][0] = new Mouse;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                board[x][y] = new ScoreCell();
            }
        }
        //Special tiles method
    }
    public void showBoard(){
        for ( GameCell[] row : board){
            for (GameCell cell : row){
                System.out.print(cell.toString()+ " ");
            }
            System.out.println();
        }
    }
}
