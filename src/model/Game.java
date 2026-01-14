package model;

import parser.ParseException;
import parser.Parser;
import parser.Statement;
import strategy.IdleStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Board board;
    private final List<Minion> minions = new ArrayList<>();
    private final List<Enemy> enemies = new ArrayList<>();

    public Game() {
        board = new Board(6, 6);

        // Minion เริ่มต้น
        minions.add(new Soldier(
                new IdleStrategy(),
                0,
                0
        ));

        // Enemy ตัวอย่าง
        enemies.add(new Enemy(1, 3, 10));
    }

    public Board getBoard() {
        return board;
    }

    public void printBoard() {
        board.printBoard(minions, enemies);
    }

    public void runScript(String script) {
        try {
            Parser parser = new Parser(script);
            Statement<Minion> stmt = parser.parse();
            stmt.execute(minions.get(0), this);
        } catch (ParseException e) {
            System.out.println("Script error: " + e.getMessage());
        }
    }

    public List<Minion> getMinions() {
        return minions;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

}
