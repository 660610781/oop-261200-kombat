package parser;

import model.Game;

public interface Statement<T> {
    void execute(T target, Game game);
}
