package parser;

import model.*;
import strategy.AggressiveStrategy;

public class AggressiveStmt implements Statement<Minion> {
    @Override
    public void execute(Minion minion, Game game) {
        minion.setStrategy(new AggressiveStrategy());
        System.out.println("Minion switches to aggressive");
    }
}
