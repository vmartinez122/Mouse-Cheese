import java.util.ArrayList;
import java.util.Scanner;

public class Main {
Mouse mouse = new Mouse(0, 0);
Board board = new Board(mouse);
Scanner input = new Scanner(System.in);
boolean end = false;

    public static void main(String[] args){
        Main program = new Main();
        program.start();
    }

    private void start(){
        board.showBoard();
        while (!end){
            gameTurn();
        }
    }

    private void gameTurn(){
        String move = input.nextLine();
        mouse.mouseMove(move);
        board.showBoard();
    }


}