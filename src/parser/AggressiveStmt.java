package parser;

import model.Game;
import model.Minion;
import strategy.AggressiveStrategy;

public class AggressiveStmt implements Statement {

    @Override
    public void execute(Minion minion, Game game) {
        minion.setStrategy(new AggressiveStrategy());
        minion.takeTurn(game);
    }
}
