package model;

import strategy.IdleStrategy;
import strategy.AggressiveStrategy;


public class Game {
    private int turn = 1;
    private Board board;
    private Minion minion;

    public Game() {
        board = new Board(8, 8);
        minion = new Soldier(new AggressiveStrategy());

    }

    public void nextTurn() {
        System.out.println("Turn " + turn);
        board.printBoard();
        minion.takeTurn(this);
        turn++;
    }
}
