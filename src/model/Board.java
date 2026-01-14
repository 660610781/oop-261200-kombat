package model;

import java.util.List;

public class Board {

    private final int rows;
    private final int cols;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public boolean isInside(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public void printBoard(List<Minion> minions, List<Enemy> enemies) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                boolean printed = false;

                for (Enemy e : enemies) {
                    if (!e.isDead() && e.getRow() == r && e.getCol() == c) {
                        System.out.print("E ");
                        printed = true;
                        break;
                    }
                }

                if (printed) continue;

                for (Minion m : minions) {
                    if (m.getRow() == r && m.getCol() == c) {
                        System.out.print("M ");
                        printed = true;
                        break;
                    }
                }

                if (!printed) {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
