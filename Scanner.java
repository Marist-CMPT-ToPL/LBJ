public class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int start = 0; 
    private int current = 0;
    private int line = 1;

    private static final Map<String, TokenType> keywords = new HashMap<>(); static {
        keywords.put("if", TokenType.IF);
        keywords.put("for", TokenType.FOR);
        keywords.put("else", TokenType.ELSE);
        keywords.put("return", TokenType.RETURN);
        keywords.put("while", TokenType.WHILE);
        keywords.put("true", TokenType.TRUE);
        keywords.put("false", TokenType.FALSE);
        keywords.put("nil", TokenType.NIL);
        keywords.put("or", TokenType.OR);
        keywords.put("function", TokenType.FUNCTION);
        keywords.put("let", TokenType.LET);
        keywords.put("constant", TokenType.CONSTANT);
        keywords.put("variable", TokenType.VARIABLE);
        keywords.put("enum", TokenType.ENUM);
        keywords.put("and", TokenType.AND);
        keywords.put("not", TokenType.NOT);
    }
public Scanner(String source) {
        this.source = source;
    }

public List<Token> scanTokens() {
        while (!isAtEnd()) {
            start = current;
            scanTokens();
        }
        tokens.add(new Token(TokenType.EOF, "", null, line));
        return tokens;
    }
}