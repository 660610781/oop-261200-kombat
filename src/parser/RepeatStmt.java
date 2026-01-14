package parser;

import model.Game;
import model.Minion;
import java.util.List;

public class RepeatStmt implements Statement<Minion> {
    private final int times;
    private final List<Statement<Minion>> body;

    public RepeatStmt(int times, List<Statement<Minion>> body) {
        this.times = times;
        this.body = body;
    }

    @Override
    public void execute(Minion minion, Game game) {
        for (int i = 0; i < times; i++) {
            for (Statement<Minion> s : body) {
                s.execute(minion, game);
            }
        }
    }
}
