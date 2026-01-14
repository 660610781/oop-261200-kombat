package strategy;

import model.Enemy;
import model.Game;
import model.Minion;

public class AggressiveStrategy implements Strategy {

    @Override
    public void attack(Minion minion, Game game) {
        for (Enemy e : game.getEnemies()) {
            if (Math.abs(e.getRow() - minion.getRow()) +
                    Math.abs(e.getCol() - minion.getCol()) == 1) {

                e.takeDamage(5);
                System.out.println("Minion attacks aggressively!");
                return;
            }
            if (e.isDead()) {
                game.getEnemies().remove(e);
            }

        }

        System.out.println("No enemy in range.");
    }
}
