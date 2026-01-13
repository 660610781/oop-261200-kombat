package model;

import strategy.IdleStrategy;
import strategy.AggressiveStrategy;
import parser.*;
import java.util.List;
import parser.Parser;
import parser.Statement;
import java.util.List;




public class Game {
    private int turn = 1;
    private Board board;
    private Minion minion;

    public Game() {
        board = new Board(8, 8);
        minion = new Soldier(new AggressiveStrategy(), 0, 0);

    }

    public void nextTurn() {
        System.out.println("Turn " + turn);
        board.printBoard(minion);


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

            for (Statement stmt : program) {
                stmt.execute(minion, this);
            }
        } catch (ParseException e) {
            System.out.println("Script error: " + e.getMessage());
        }

        turn++;
    }

    public Board getBoard() {
        return board;
    }

}
