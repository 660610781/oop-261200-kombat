package model;

import strategy.Strategy;

public abstract class Minion {

    protected int row;
    protected int col;
    protected Strategy strategy;

    public Minion(Strategy strategy, int row, int col) {
        this.strategy = strategy;
        this.row = row;
        this.col = col;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void move(int dRow, int dCol, Board board) {
        int newRow = row + dRow;
        int newCol = col + dCol;

        if (!board.isInside(newRow, newCol)) {
            System.out.println("Minion hits the wall!");
            return;
        }

        row = newRow;
        col = newCol;
        System.out.println("Minion moves to (" + row + ", " + col + ")");
    }

    public void attack(Game game) {
        strategy.attack(this, game);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
