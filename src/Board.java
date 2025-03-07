import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board {
    private Random rand = new Random();
    private Mouse mouse;
    private final int SIZE = 4;
    private GameCell[][] board;
    private int[] mouse_pos; //Coordenedas (x,y) ratón

    public Board(Mouse mouse) {
        this.mouse = mouse;
        mouse_pos = mouse.getCoords();
        board = new GameCell[SIZE][SIZE];
        createBoard();
    }

    private void createBoard(){
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                board[x][y] = new ScoreCell();
            }
        }
        specialCells();
        board[mouse_pos[1]][mouse_pos[0]].setDiscovered();
    }

    public ArrayList<String> boardScan(){
        mouse_pos = mouse.getCoords();
        ArrayList<String> valid_movement = new ArrayList<>();
        int x = mouse_pos[0];
        int y = mouse_pos[1];
        if (canMoveTo(x,y-1)){
            valid_movement.add("w");
        }
        if (canMoveTo(x-1,y)){
            valid_movement.add("a");
        }
        if (canMoveTo(x,y+1)){
            valid_movement.add("s");
        }
        if (canMoveTo(x+1,y)){
            valid_movement.add("d");
        }
        return valid_movement;
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
    public GameCell returnCurrCell(){
        return board[mouse_pos[1]][mouse_pos[0]];
    }

    /**
     * Muestra todas las casillas en orden, incluyendo la casilla donde se encuentra el ratón.
     */
    public void showBoard(){
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

    /**
     * TODO: Muestra
     *
     */
    public void showTestBoard(){
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

    /**
     * Introduce las celdas especiales (EndGameCell,Cat,SubtractCell y SumCell)
     * Toma nota de sus posiciones, para que siempre haya una de cada tipo.
     */
    private void specialCells(){
        //El ArrayList coord_list contiene pares de coordenadas (x,y), para tomar lista de las casillas ya ocupadas.
        //La función asList(), permite introducir una lista de tamaño fijo para inicializar el ArrayList
        ArrayList<Integer[]> coord_list = new ArrayList<>(Arrays.asList(
                new Integer[] {mouse_pos[0], mouse_pos[1]}, //Mouse
                new Integer[] {SIZE-1, SIZE-1} //Cheese
        ));
        Integer[] coord;
        board[SIZE-1][SIZE-1] = new EndGameCell(EndGamecellType.Cheese); //Crea un objeto tipo Cheese
        for (int i = 0; i < 3; i++) {
            do {
                coord = new Integer[2]; //Inicializamos dentro del bucle o se editará siempre el mismo objeto
                coord[0] = rand.nextInt(0,SIZE);
                coord[1] = rand.nextInt(0,SIZE);
            }while (containsCoord(coord_list,coord));
            coord_list.add(coord);

            switch (i){
                case 0:
                    board[coord[0]][coord[1]] = new SubtractCell();
                    break;
                case 1:
                    board[coord[0]][coord[1]] = new SumCell();
                    break;
                case 2:
                    board[coord[0]][coord[1]] = new EndGameCell(EndGamecellType.Cat);
                    break;
                default:
                    System.out.println("Generation error, can't place more cells.");
                    break;
            }
        }
    }

    /**
     * Comprueba que el array de cordenadas (x,y), no esté ya dentro de una lista.
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
