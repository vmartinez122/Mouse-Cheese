import model.Mouse;

import java.util.Scanner;

public class Main {
Mouse mouse = new Mouse(0, 0);
Board board = new Board(mouse);
Scanner input = new Scanner(System.in);
private boolean end = false;
private int turn;

    public static void main(String[] args){
        Main program = new Main();
        program.start();
    }

    private void start(){
        turn = 1;
        while (!end){
            gameTurn();
        }
    }

    private void gameTurn(){
        System.out.println("\nTURNO: "+turn);
        //board.movable();
        board.boardScan();
        board.showBoard();
        String move = input.nextLine();
        //Ask nearby cells ifDiscovered() Board
        mouse.mouseMove(move);
        //!! DISCOVERED CELL ACTION !!, needs (x,y from mouse)
        turn++;
    }


}