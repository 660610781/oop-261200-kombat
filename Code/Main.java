import Model.Game.*;
import Model.Strategy.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(5, 5);

        board.printBoard();

        Minion m1 = new Minion("bot A", 100);
        Minion m2 = new Minion("bot B", 100);

        board.putMinion(m1, 1, 1);
        board.putMinion(m2, 5, 5);

        board.printBoard();
    }
}