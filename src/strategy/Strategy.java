package strategy;

import model.Game;
import model.Minion;

public interface Strategy {

    void attack(Minion minion, Game game);

}
