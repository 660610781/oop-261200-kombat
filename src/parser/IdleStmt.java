package parser;

import model.*;
import strategy.IdleStrategy;

public class IdleStmt implements Statement<Minion> {
    @Override
    public void execute(Minion minion, Game game) {
        minion.setStrategy(new IdleStrategy());
        System.out.println("Minion switches to idle");
    }
}
