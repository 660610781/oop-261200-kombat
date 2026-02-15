package Model.Strategy.AST;

import Model.Game.Game;
import Model.Game.Minion;

public interface Expr extends Node  {
    double eval(Game game , Minion minion);
}
