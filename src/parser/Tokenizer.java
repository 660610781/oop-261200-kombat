package parser;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    private final List<String> tokens;
    private int pos = 0;

    public Tokenizer(String input) {
        input = input.replace("{", " { ")
                .replace("}", " } ")
                .trim(); // ⭐ เพิ่มบรรทัดนี้

        this.tokens = List.of(input.split("\\s+"));
    }


    public boolean hasNext() {
        return pos < tokens.size();
    }

    public String peek() {
        return tokens.get(pos);
    }

    public String next() {
        return tokens.get(pos++);
    }
}
