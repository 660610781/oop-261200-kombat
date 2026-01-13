package parser;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final Tokenizer tokenizer;

    public Parser(String input) {
        this.tokenizer = new Tokenizer(input);
    }

    public List<Statement> parseProgram() {
        List<Statement> statements = new ArrayList<>();
        while (tokenizer.hasNext()) {
            statements.add(parseStatement());
        }
        return statements;
    }

    private Statement parseStatement() {
        String token = tokenizer.next();

        if (token.equals("idle")) {
            return new IdleStmt();
        }

        if (token.equals("aggressive")) {
            return new AggressiveStmt();
        }

        // ⭐ ใส่ move ตรงนี้
        if (token.equals("move")) {
            String dir = tokenizer.next();

            return switch (dir) {
                case "up" -> new MoveStmt(-1, 0);
                case "down" -> new MoveStmt(1, 0);
                case "left" -> new MoveStmt(0, -1);
                case "right" -> new MoveStmt(0, 1);
                default -> throw new ParseException("ทิศทาง move ไม่ถูกต้อง: " + dir);
            };
        }

        if (token.equals("repeat")) {
            int times = Integer.parseInt(tokenizer.next());
            tokenizer.next(); // "{"

            List<Statement> body = new ArrayList<>();
            while (!tokenizer.peek().equals("}")) {
                body.add(parseStatement());
            }
            tokenizer.next(); // "}"

            return new RepeatStmt(times, body);
        }

        throw new ParseException("คำสั่งไม่รู้จัก: " + token);
    }

}
