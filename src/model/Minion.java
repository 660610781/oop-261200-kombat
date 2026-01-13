package model;

import strategy.Strategy;

public abstract class Minion {
    protected int hp;
    protected Strategy strategy;

    public Minion(int hp, Strategy strategy) {
        this.hp = hp;
        this.strategy = strategy;
    }

    public void takeTurn(Game game) {
        strategy.execute(this, game);
    }

    public int getHp() {
        return hp;
    }
}
