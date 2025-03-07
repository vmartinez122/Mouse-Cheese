import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
Mouse mouse;
Board board;
Scanner input = new Scanner(System.in);
private boolean end = false;
private boolean win = false;
private int turn;

    public static void main(String[] args){
        Main program = new Main();
        program.start();
    }

    private void start(){
        mouse = new Mouse(0, 0);
        board = new Board(mouse);
        turn = 1;

        System.out.println("""
                Welcome to Cheese Mouse Game!!!
                Move the mouse 'MM' to reach the cheese 'CH'.
                Controls:
                w: move up
                a: move left
                s: move down
                d: move right""");

        while (!end){
            gameTurn();
        }
        if(win){
            System.out.println("YOU WIN!!");

        }else {
            System.out.println("YOU LOOSE");

        }
        System.out.println("Total score: "+mouse.getScore());
    }

    /**
     * Bucle de juego principal, se encarga de mover al ratón y manejar el tablero
     */
    private void gameTurn(){
        System.out.println("\nTURNO: "+turn);
        System.out.println("Score: "+mouse.getScore());
        board.showBoard();
        ArrayList<String> movements = board.boardScan(); //Recibe una lista de movimientos posibles
        if(movements.isEmpty()){ //Si no hay movimientos posibles, la partida acaba
            end = true;
            return;
        }
        mouse.mouseMove(checkMove(movements)); //Envía al ratón la dirección en la que se ha de mover, después de comprobarla.
        cellAction();
        turn++;
    }

    /**
     * Pide un input al usuario y comprueba que esté dentro de una lista de posibles movimientos
     * @param movements ArrayList de posibles movimientos
     * @return movimiento válido.
     */
    private String checkMove(ArrayList<String> movements){
        String move;
        do{
            System.out.print("Move mouse:");
            move = input.nextLine();
            if (movements.contains(move)){
                return move;
            }
            System.out.println("Invalid movement.");
        } while (true);
    }

    /**
     * Llama a los métodos correspondientes de la celda donde se encuentra el ratón actualmente,
     * dependiendo la instancia de esta.
     */
    public void cellAction(){
        GameCell cell = board.returnCurrCell();
        cell.setDiscovered();
        if ( cell instanceof Questionable){
            System.out.print(((Questionable) cell).getQuestion());
            ((Questionable) cell).submitAnswer(input.nextLine());

        }else if (cell instanceof EndGameCell){
            if(((EndGameCell) cell).getType() == EndGamecellType.Cheese){
                win = true;
            }
            end = true;
            return;
        }
        //Las demás celdas, suman el valor directamente

        /* He considerado crear un metodo getValue() en la superclase GameCell.
        Sin este, tendríamos que validar el tipo de celda del que se trata individualmente,
        en cuyo caso se perdería la utilidad de una jerarquía de clases.
        */
        mouse.addScore((cell).getValue());
    }


}