package model;

import strategy.Strategy;

public class Soldier extends Minion {

    public Soldier(Strategy strategy) {
        super(10, strategy);
    }
}
