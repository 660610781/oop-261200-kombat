package parser;

import model.Game;
import model.Minion;

import java.util.List;

public class RepeatStmt implements Statement {

    private final int times;
    private final List<Statement> body;

    public RepeatStmt(int times, List<Statement> body) {
        this.times = times;
        this.body = body;
    }

    @Override
    public void execute(Minion minion, Game game) {
        for (int i = 0; i < times; i++) {
            for (Statement stmt : body) {
                stmt.execute(minion, game);
            }
        }
    }
}
