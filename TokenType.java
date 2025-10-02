import java.util.*;

public enum TokenType {
    //Single-character tokens.
    LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE, COMMA, DOT, 
    SEMICOLON, STAR, COLON,

    //Operators
    MINUS, PLUS, SLASH, PERCENT, BANG, BANG_EQUAL, STAR, EQUAL,
    LESS, LESS_EQUAL, GREATER, GREATER_EQUAL, AND_AND, OR_OR,

    // Literals & identifiers
    IDENTIFIER, NUMBER, STRING, CHAR,

    // Keywords
    IF, FOR, ELSE, RETURN, WHILE, TRUE, FALSE, NIL, OR, FUNCTION,
    LET, CONSTANT, VARIABLE, ENUM, AND, NOT, EOF, ERROR
}