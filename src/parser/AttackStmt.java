package parser;

import model.*;

public class AttackStmt implements Statement<Minion> {
    @Override
    public void execute(Minion minion, Game game) {
        minion.attack(game);
    }
}
