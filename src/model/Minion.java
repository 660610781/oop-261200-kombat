package model;

import strategy.Strategy;

public abstract class Minion {
    protected int hp;
    protected Strategy strategy;
    protected int row;
    protected int col;


    public Minion(int hp, Strategy strategy, int row, int col) {
        this.hp = hp;
        this.strategy = strategy;
        this.row = row;
        this.col = col;
    }


    public void takeTurn(Game game) {
        strategy.execute(this, game);
    }

    // ⭐ เพิ่มเข้ามาใหม่
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void move(int dRow, int dCol, Board board) {
        int newRow = row + dRow;
        int newCol = col + dCol;

        if (newRow < 0 || newRow >= board.getRows()
                || newCol < 0 || newCol >= board.getCols()) {
            System.out.println("Minion hits the wall!");
            return;
        }

        row = newRow;
        col = newCol;
        System.out.println("Minion moves to (" + row + ", " + col + ")");
    }


}
