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
    public final Token param; 
    public final Expr body;
    public Lambda(Token param, Expr body) {
        this.param = param;
        this.body = body;
    }
    public String toString() {
        return "(lambda " + (param == null ? "_" : param.lexeme) + " => " + body + ")";
    }
}

public static class ExprStmt extends Stmt {
    public final Expr expression;
    public ExprStmt(Expr expression) { 
        this.expression = expression; 
    }
    public String toString() { 
        return expression.toString();
     }
}

public static class VarStmt extends Stmt {
    public final Token name;
    public final Expr initializer;
    public final Token kind; 
    public VarStmt(Token kind, Token name, Expr initializer) { 
        this.kind = kind; 
        this.name = name; 
        this.initializer = initializer; 
    }
    public String toString() { 
        return "(var " + name.lexeme + " = " + (initializer == null ? "nil" : initializer) + ")"; 
    }
}

public static class FunctionStmt extends Stmt {
    public final Token name;
    public final List<Token> params;
    public final List<Stmt> body;
    public FunctionStmt(Token name, List<Token> params, List<Stmt> body) { 
        this.name = name; 
        this.params = params; 
        this.body = body; 
    }
    public String toString() { 
        return "(fun " + name.lexeme + " params=" + params + " body=" + body + ")"; 
    }
}


public static class StructStmt extends Stmt {
    public final Token name;
    public final List<Token> fields;
    public StructStmt(Token name, List<Token> fields) { 
        this.name = name; 
        this.fields = fields; 
    }
    public String toString() { 
        return "(struct " + name.lexeme + " fields=" + fields + ")"; 
    }
}

public static class EnumStmt extends Stmt {
    public final Token name; 
    public final List<Token> members;
    public EnumStmt(Token name, List<Token> members) { 
        this.name = name; 
        this.members = members; 
    }
    public String toString() { 
        return "(enum " + name.lexeme + " members=" + members + ")"; 
    }
}

public static class BlockStmt extends Stmt {
    public final List<Stmt> statements;
    public BlockStmt(List<Stmt> statements) { 
        this.statements = statements; 
    }
    public String toString() { 
        return "(block " + statements + ")"; 
    }
}


public static class IfStmt extends Stmt {
    public final Expr condition; 
    public final Stmt thenBranch; 
    public final Stmt elseBranch;
    public IfStmt(Expr condition, Stmt thenBranch, Stmt elseBranch) { 
        this.condition = condition; this.thenBranch = thenBranch; this.elseBranch = elseBranch; 
    }
    public String toString() { 
        return "(if " + condition + " then " + thenBranch + " else " + elseBranch + ")"; 
    }
}


public static class WhileStmt extends Stmt {
    public final Expr condition; 
    public final Stmt body; 
    public WhileStmt(Expr condition, Stmt body) { 
        this.condition = condition; 
        this.body = body; 
    }
    public String toString() { 
        return "(while " + condition + " " + body + ")"; 
    }
}


public static class ForStmt extends Stmt {
    public final Stmt initializer; 
    public final Expr condition; 
    public final Expr increment; 
    public final Stmt body;

public static class ContinueStmt extends Stmt { 
    public final Token keyword; 
    public ContinueStmt(Token kw) { this.keyword = kw; } 
    public String toString() { 
        return "(continue)"; 
    }
  }
} 



