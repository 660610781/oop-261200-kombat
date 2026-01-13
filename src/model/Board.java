package model;

public class Board {
    private final int rows;
    private final int cols;
    private final Hex[][] grid;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Hex[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Hex(r, c);
            }
        }
    }

    public Hex getHex(int r, int c) {
        return grid[r][c];
    }

    public void printBoard(Minion minion) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == minion.getRow() && c == minion.getCol()) {
                    System.out.print("M ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }


    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

}
