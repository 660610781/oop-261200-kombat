package strategy;

import model.Game;
import model.Minion;

public class IdleStrategy implements Strategy {

    @Override
    public void attack(Minion self, Game game) {
        System.out.println("Minion is idling...");
    }
}
