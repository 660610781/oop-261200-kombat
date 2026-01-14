package parser;

import model.Game;
import model.Minion;

public class PrintStmt implements Statement<Minion> {

    @Override
    public void execute(Minion minion, Game game) {
        game.getBoard().printBoard(
                game.getMinions(),
                game.getEnemies()
        );
    }
}
