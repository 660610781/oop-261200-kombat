package parser;

import model.Minion;
import java.util.*;

public class Parser {

    private final Tokenizer tokenizer;

    public Parser(String script) {
        this.tokenizer = new Tokenizer(script);
    }

    public Statement<Minion> parse() throws ParseException {
        List<Statement<Minion>> stmts = new ArrayList<>();

        while (tokenizer.hasNext()) {
            stmts.add(parseStatement());
        }

        return new SequenceStmt(stmts);
    }

    // 🔥 เมธอดที่คุณถามถึง
    private Statement<Minion> parseStatement() throws ParseException {
        String token = tokenizer.peek();

        if (token == null) {
            throw new ParseException("Unexpected end of input");
        }

        // move
        if (token.equals("move")) {
            tokenizer.next(); // move
            String dir = tokenizer.next();
            return new MoveStmt(dir);
        }

        // attack
        if (token.equals("attack")) {
            tokenizer.next();
            return new AttackStmt();
        }

        // aggressive
        if (token.equals("aggressive")) {
            tokenizer.next();
            return new AggressiveStmt();
        }

        // idle
        if (token.equals("idle")) {
            tokenizer.next();
            return new IdleStmt();
        }

        // print
        if (token.equals("print")) {
            tokenizer.next();
            return new PrintStmt();
        }

        // repeat
        if (token.equals("repeat")) {
            tokenizer.next(); // repeat
            String num = tokenizer.next();

            int times;
            try {
                times = Integer.parseInt(num);
            } catch (NumberFormatException e) {
                throw new ParseException("จำนวนครั้งของ repeat ต้องเป็นตัวเลข");
            }

            tokenizer.expect("{");

            List<Statement<Minion>> body = new ArrayList<>();
            while (!tokenizer.peek().equals("}")) {
                body.add(parseStatement());
            }

            tokenizer.expect("}");
            return new RepeatStmt(times, body);
        }

        // ❌ unknown command
        throw new ParseException("คำสั่งไม่รู้จัก: " + token);
    }
}
