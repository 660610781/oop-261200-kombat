package model;

public class Game {
    private int turn = 1;
    private Board board;

    public Game() {
        board = new Board(8, 8);
    }

    public void nextTurn() {
        System.out.println("Turn " + turn);
        board.printBoard();
        turn++;
    }
}
