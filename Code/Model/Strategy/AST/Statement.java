package Model.Strategy.AST;

import Model.Game.*;

interface Statement extends Node{
    void execute(Game game , Minion minion);
}
