import java.util.*;

public enum TokenType {
    //Single-character tokens.
    LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE, COMMA, DOT, 
    SEMICOLON, COLON, LEFT_BRACKET, RIGHT_BRACKET,

    //Operators
    MINUS, PLUS, SLASH, PERCENT, BANG, BANG_EQUAL, STAR, EQUAL,
    LESS, LESS_EQUAL, GREATER, GREATER_EQUAL, AND_AND, OR_OR,

    // Literals & identifiers
    IDENTIFIER, NUMBER, STRING, CHAR,

    // Keywords
    IF, FOR, ELSE, RETURN, WHILE, TRUE, FALSE, NIL, OR, FUNCTION,
    LET, CONSTANT, VARIABLE, ENUM, AND, NOT, EOF, ERROR
}

class Token {
    final TokenType type;
    final String lexeme;
    final Object literal;
    final int line;

    Token(TokenType type, String lexeme, Object literal, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }

    public String toString() {
        return String.format("[%d] %s %s %s", type, line, lexeme, literal == null? "" : literal);
    }
}
