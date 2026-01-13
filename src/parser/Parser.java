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

        if (token.equals("repeat")) {
            int times = Integer.parseInt(tokenizer.next());
            tokenizer.next(); // skip "{"

            List<Statement> body = new ArrayList<>();
            while (!tokenizer.peek().equals("}")) {
                body.add(parseStatement());
            }
            tokenizer.next(); // skip "}"

            return new RepeatStmt(times, body);
        }

        throw new RuntimeException("Unknown token: " + token);
    }
}
