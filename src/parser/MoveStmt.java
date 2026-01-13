package parser;

import model.Game;
import model.Minion;

public class MoveStmt implements Statement {

    private final int dRow;
    private final int dCol;

    public MoveStmt(int dRow, int dCol) {
        this.dRow = dRow;
        this.dCol = dCol;
    }

    @Override
    public void execute(Minion minion, Game game) {
        minion.move(dRow, dCol, game.getBoard());

    }
}
