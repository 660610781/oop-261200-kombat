package strategy;

import model.Game;
import model.Minion;

public class AggressiveStrategy implements Strategy {

    @Override
    public void execute(Minion self, Game game) {
        System.out.println("Minion attacks aggressively!");
    }
}
