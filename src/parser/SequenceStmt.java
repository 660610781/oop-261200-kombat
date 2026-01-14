package parser;

import model.Game;
import model.Minion;
import java.util.List;

public class SequenceStmt implements Statement<Minion> {

    private final List<Statement<Minion>> stmts;

    public SequenceStmt(List<Statement<Minion>> stmts) {
        this.stmts = stmts;
    }

    @Override
    public void execute(Minion minion, Game game) {
        for (Statement<Minion> s : stmts) {
            s.execute(minion, game);
        }
    }
}
