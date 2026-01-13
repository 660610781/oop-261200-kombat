package strategy;

import model.Game;
import model.Minion;

public interface Strategy {
    void execute(Minion self, Game game);
}
