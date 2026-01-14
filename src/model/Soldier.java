package model;

import strategy.Strategy;

public class Soldier extends Minion {

    public Soldier(Strategy strategy, int row, int col) {
        super(strategy, row, col);
    }
}
