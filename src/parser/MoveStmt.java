package parser;

import model.*;

public class MoveStmt implements Statement<Minion> {
    private final String dir;

    public MoveStmt(String dir) {
        this.dir = dir;
    }

    @Override
    public void execute(Minion minion, Game game) {
        switch (dir) {
            case "up" -> minion.move(-1, 0, game.getBoard());
            case "down" -> minion.move(1, 0, game.getBoard());
            case "left" -> minion.move(0, -1, game.getBoard());
            case "right" -> minion.move(0, 1, game.getBoard());
            default -> System.out.println("ทิศทางไม่ถูกต้อง: " + dir);
        }
    }
}
