import java.util.Random;

public class Board {
    private GameCell[][] board;
    private final int SIZE = 4;
    private Random rand = new Random();
    private Mouse mouse;

    public Board(Mouse mouse) {
        this.mouse = mouse;
        board = new GameCell[SIZE][SIZE];
        createBoard();
    }
    private void createBoard(){
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                board[x][y] = new ScoreCell();
            }
        }
        //Special tiles method
    }

    /*
    public void showBoard(){
        for ( GameCell[] row : board){
            for (GameCell cell : row.index){
                if (mouse.isMouse(cell,row))
                System.out.print(cell+ " ");
            }
            System.out.println(); //Salto de línea
        }


    }*/

    public void showBoard(){
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (mouse.isMouse(x,y)){
                    System.out.print("MM ");
                }else {
                    System.out.print(board[x][y]+ " ");
                }
            }
            System.out.println(); //Salto de línea
        }
    }

}
