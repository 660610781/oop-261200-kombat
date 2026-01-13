package parser;

import model.Game;
import model.Minion;

public interface Statement {
    void execute(Minion minion, Game game);
}
