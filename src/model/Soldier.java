package model;

import strategy.Strategy;

public class Soldier extends Minion {

    public Soldier(Strategy strategy, int row, int col) {
        super(10, strategy, row, col);
    }

}
