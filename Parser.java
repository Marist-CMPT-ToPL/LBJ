package lbj;

import static lbj.TokenType.*;

class Parser {
  private static class ParseError extends RuntimeException {}

  private final List<Token> tokens;
  private int current = 0;

  Parser(List<Token> tokens) {
    this.tokens = tokens;
  }

public static class Binary extends Expr {
    public final Expr left;
    public final Token operator;
    public final Expr right;

public Binary(Expr left, Token operator, Expr right) {
    this.left = left;
    this.operator = operator;
    this.right = right;
    }
 }

public String toString() { 
    return "(" + operator.lexeme + " " + left + " " + right + ")";
}

    public final Expr right;
    public Unary(Token operator, Expr right) {
        this.operator = operator;
        this.right = right;
    }

public String toString() {
    return "(" + operator.lexeme + " " + right + ")";
}
}

public static class Variable extends Expr {
    public final Token name;
    public Variable(Token name) { 
        this.name = name; 
    }
    public String toString() {
        return name.lexeme;
    }
}

public static class Assign extends Expr {
    public final Token name;
    public final Expr value;
    public Assign(Token name, Expr value) { 
        this.name = name; this.value = value; 
    }
    public String toString() {
        return "(assign " + name.lexeme + " " + value + ")";
    }
}

public static class Call extends Expr {
    public final Expr callee;
    public final Token paren;
    public final List<Expr> arguments;
    public Call(Expr callee, Token paren, List<Expr> arguments) {
        this.callee = callee;
        this.paren = paren;
        this.arguments = arguments;
    }
    public String toString() {
        return "(call " + callee + " args=" + arguments + ")";
    }
}

public static class Get extends Expr {
    public final Expr object;
    public final Token name;
    public Get(Expr object, Token name) {
        this.object = object;
        this.name = name;
    }
    public String toString() {
        return "(" + object + "." + name.lexeme + ")";
    }
}

public static class Index extends Expr {
    public final Expr object;
    public final Expr index;
    public Index(Expr object, Expr index) {
        this.object = object;
        this.index = index;
    }
    public String toString() {
        return "(" + object + "[" + index + "])";
    }
}

public static class Lambda extends Expr {
    public final Token param; // allow single param or null
    public final Expr body;
    public Lambda(Token param, Expr body) {
        this.param = param;
        this.body = body;
    }
    public String toString() {
        return "(lambda " + (param == null ? "_" : param.lexeme) + " => " + body + ")";
    }
}


