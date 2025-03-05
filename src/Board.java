import java.util.ArrayList;
import java.util.Arrays;
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
                board[x][y] = new ScoreCell(x,y);
            }
        }
        specialCells();
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
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (mouse.isMouse(col, row)){
                    board[row][col].setDiscovered();
                    System.out.print("MM ");
                }else {
                    System.out.print(board[row][col]+ " ");
                }
            }
            System.out.println(); //Salto de línea
        }
    }

    private void specialCells(){
        //La función as list, permite introducir valores... (Inicializa arrayList)
        ArrayList<Integer[]> table = new ArrayList<>(Arrays.asList(
                new Integer[] {0, 0}, //Mouse
                new Integer[] {SIZE-1, SIZE-1} //Cheese
        ));
        Integer[] coord;
        board[SIZE-1][SIZE-1] = new EndGameCell(SIZE-1,SIZE-1, EndGamecellType.Cheese);

        for (int i = 0; i < 3; i++) {
            do {
                coord = new Integer[2]; //Inicializamos dentro del bucle o se editará siempre el mismo objeto
                coord[0] = rand.nextInt(0,SIZE);
                coord[1] = rand.nextInt(0,SIZE);
            }while (containsCoord(table,coord));
            table.add(coord);
            //System .out.println("Table:"+table);
            for(Integer[] coords : table){
                for (Integer x : coords){
                    System.out.print(x+",");
                }
                System.out.print("|");
            }
            System.out.println();
            switch (i){
                case 0:
                    System.out.println("Subtract:"+coord[0]+","+coord[1]);
                    board[coord[0]][coord[1]] = new SubtractCell(coord[0],coord[1]);
                    break;
                case 1:
                    System.out.println("Sum:"+coord[0]+","+coord[1]);
                    board[coord[0]][coord[1]] = new SumCell(coord[0],coord[1]);
                    break;
                case 2:
                    System.out.println("Cat:"+coord[0]+","+coord[1]);
                    board[coord[0]][coord[1]] = new EndGameCell(coord[0],coord[1],EndGamecellType.Cat);
                    break;
                default:
                    System.out.println("Generation error");
                    break;
            }
        }
    }

    private boolean containsCoord(ArrayList<Integer[]> table, Integer[] coord) {
        for (Integer[] existing : table) {
            if (existing[0].equals(coord[0]) && existing[1].equals(coord[1])) {
                return true; // Ya existe en la lista
            }
        }
        return false;
    }
}
