package parser;

import java.util.*;

public class Tokenizer {
    private final List<String> tokens;
    private int index = 0;

    public Tokenizer(String src) {
        src = src.replace("{", " { ").replace("}", " } ");

        tokens = new ArrayList<>();
        for (String t : src.split("\\s+")) {
            if (!t.isBlank()) {
                tokens.add(t);
            }
        }
    }

    public boolean hasNext() {
        return index < tokens.size();
    }

    public String next() {
        return hasNext() ? tokens.get(index++) : null;
    }

    public String peek() {
        return hasNext() ? tokens.get(index) : null;
    }

    public void expect(String s) throws ParseException {
        String t = next();
        if (!s.equals(t)) {
            throw new ParseException("คาดว่าเป็น '" + s + "' แต่เจอ '" + t + "'");
        }
    }
}
