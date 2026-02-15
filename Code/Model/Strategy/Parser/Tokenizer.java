package Model.Strategy.Parser;

interface Tokenizer {
    boolean hasNextToken();
    String peek();
    String consume();
}
