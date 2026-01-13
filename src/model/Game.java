package model;

import strategy.IdleStrategy;
import strategy.AggressiveStrategy;
import parser.*;
import java.util.List;
import parser.Parser;
import parser.Statement;
import java.util.ArrayList;
import java.util.List;





public class Game {
    private int turn = 1;
    private Board board;
    private List<Minion> minions = new ArrayList<>();


    public Game() {
        board = new Board(8, 8);
        minions.add(new Soldier(new AggressiveStrategy(), 0, 0));
        minions.add(new Soldier(new IdleStrategy(), 2, 2));

    }

    public void nextTurn() {
        System.out.println("Turn " + turn);
        board.printBoard(minions);


        String script = """
                 move right
                 move down
                 repeat 2 {
                     move right
                 }
        """;

        try {
            Parser parser = new Parser(script);
            List<Statement> program = parser.parseProgram();

            for (Minion m : minions) {
                for (Statement stmt : program) {
                    stmt.execute(m, this);
                }
            }
        } catch (ParseException e) {
            System.out.println("Script error: " + e.getMessage());
        }

        turn++;
    }

    public Board getBoard() {
        return board;
    }

    public List<Minion> getMinions() {
        return minions;
    }

}
