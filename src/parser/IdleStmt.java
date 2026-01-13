package parser;

import model.Game;
import model.Minion;
import strategy.IdleStrategy;

public class IdleStmt implements Statement {

    @Override
    public void execute(Minion minion, Game game) {
        minion.setStrategy(new IdleStrategy());
        minion.takeTurn(game);
    }
}
