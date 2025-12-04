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

public class ScannerTest {

    private static final String[] SAMPLE_PROGRAMS = {
        // Program 1: Variables & Expressions
        """
        var x = 10;
        var y = 20;
        var z = x * y + 5;
        print z;
        """,

        // Program 2: Functions & Return
        """
        fun add(a, b) {
            return a + b;
        }
        fun main() {
            var result = add(5, 7);
            print result;
        }
        """,

        // Program 3: If / Else
        """
        var score = 87;
        if (score > 90) {
            print "A";
        } else if (score > 80) {
            print "B";
        } else {
            print "C";
        }
        """,

        // Program 4: While loop
        """
        var i = 0;
        while (i < 5) {
            print i;
            i = i + 1;
        }
        """,

        // Program 5: For loop
        """
        for (var i = 0; i < 3; i = i + 1) {
            print i;
        }
        """
    };

    public static void main(String[] args) {
        for (int i = 0; i < SAMPLE_PROGRAMS.length; i++) {
            System.out.println("=== SCANNER TEST " + (i + 1) + " ===");

            Scanner scanner = new Scanner(SAMPLE_PROGRAMS[i]);
            List<Token> tokens = scanner.scanTokens();

            for (Token t : tokens) {
                System.out.println(t);
            }

            System.out.println();
        }
    }
}
