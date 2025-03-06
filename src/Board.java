import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board {
    private GameCell[][] board;
    private final int SIZE = 4;
    private Random rand = new Random();
    private Mouse mouse;
    private int[] mouse_pos;

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
        updateMousePos();
        specialCells();
    }
    //Might delete
    private void updateMousePos(){
        mouse_pos = mouse.getCoords();
    }
    public void boardScan(){
        updateMousePos();
        int x = mouse_pos[0];
        int y = mouse_pos[1];
        if (canMoveTo(x,y-1)){
            System.out.println("Press w");
        }
        if (canMoveTo(x-1,y)){
            System.out.println("Press a");
        }
        if (canMoveTo(x,y+1)){
            System.out.println("Press s");
        }
        if (canMoveTo(x+1,y)){
            System.out.println("Press d");
        }
    }
    //To handle OutOfBound exceptions
    private boolean canMoveTo(int x, int y){
        try {
            return !board[y][x].isDiscovered();
        }catch (IndexOutOfBoundsException e){
            //La posición está fuera del array
            return false;
        }
    }


    public void showBoard(){
        updateMousePos();
        System.out.println("Mouse position: "+mouse_pos[0]+","+mouse_pos[1]);
        board[mouse_pos[1]][mouse_pos[0]].setDiscovered();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (mouse_pos[0]==col && mouse_pos[1]==row){
                    System.out.print("MM ");
                }else {
                    System.out.print(board[row][col]+ " ");
                }
            }
            System.out.println(); //Salto de línea
        }

    }

    private void specialCells(){
        //La función asList(), permite introducir valores... (Inicializa arrayList)
        ArrayList<Integer[]> table = new ArrayList<>(Arrays.asList(
                new Integer[] {mouse_pos[0], mouse_pos[1]}, //Mouse
                new Integer[] {SIZE-1, SIZE-1} //Cheese
        ));
        Integer[] coord;
        board[SIZE-1][SIZE-1] = new EndGameCell(EndGamecellType.Cheese);

        for (int i = 0; i < 3; i++) {
            do {
                coord = new Integer[2]; //Inicializamos dentro del bucle o se editará siempre el mismo objeto
                coord[0] = rand.nextInt(0,SIZE);
                coord[1] = rand.nextInt(0,SIZE);
            }while (containsCoord(table,coord));
            table.add(coord);

            /*
            //DEBUG (show coords):
            for(Integer[] coords : table){
                for (Integer x : coords){
                    System.out.print(x+",");
                }
                System.out.print("|");
            }
            System.out.println();
            */
            switch (i){
                case 0:
                    System.out.println("Subtract:"+coord[0]+","+coord[1]);
                    board[coord[0]][coord[1]] = new SubtractCell();
                    break;
                case 1:
                    System.out.println("Sum:"+coord[0]+","+coord[1]);
                    board[coord[0]][coord[1]] = new SumCell();
                    break;
                case 2:
                    System.out.println("Cat:"+coord[0]+","+coord[1]);
                    board[coord[0]][coord[1]] = new EndGameCell(EndGamecellType.Cat);
                    break;
                default:
                    System.out.println("Generation error");
                    break;
            }
        }
    }

    /**
     * Comprueba que el array de cordenadas, no esté ya dentro de una lista.
     * @param table ArrayList de coordenadas
     * @param coord Cordenadas que queremos comprobar
     * @return True si está en la lista. False si no lo está.
     */
    private boolean containsCoord(ArrayList<Integer[]> table, Integer[] coord) {
        for (Integer[] existing : table) {
            if (existing[0].equals(coord[0]) && existing[1].equals(coord[1])) {
                return true; // Ya existe en la lista
            }
        }
        return false;
    }
}
