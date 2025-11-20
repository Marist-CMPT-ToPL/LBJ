import java.util.HashMap;
import java.util.Map;

public class Interpreter implements Expr.Visitor<Object>, Stmt.Visitor<Void> {

    private final Environment globals = new Environment();
    private Environment environment = globals;


    private final Map<Expr, Integer> locals = new HashMap<>();

    public void resolve(Expr expr, int depth) {
        locals.put(expr, depth);
    }


    private Object lookUpVariable(Token name, Expr expr) {
        Integer distance = locals.get(expr);
        if (distance != null) {
            return environment.getAt(distance, name.lexeme);
        } else {
            return globals.get(name);
        }
    }

    private Object evaluate(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public Object visitVariableExpr(Expr.Variable expr) {
        return lookUpVariable(expr.name, expr);
    }

    @Override
    public Object visitAssignExpr(Expr.Assign expr) {
        Object value = evaluate(expr.value);
        Integer distance = locals.get(expr);
        if (distance != null) {
            environment.assignAt(distance, expr.name, value);
        } else {
            globals.assign(expr.name, value);
        }
        return value;
    }
    
    @Override public Object visitBinaryExpr(Expr.Binary expr) {
        // Implementation for binary expressions
        return null; // Placeholder
    }

    @Override public Object visitUnaryExpr(Expr.Unary expr) {
        // Implementation for unary expressions
        return null; // Placeholder
    }

    @Override public Void visitReturnStmt(Stmt.Return stmt) {
        // Implementation for return statements
        return null; // Placeholder
    }

    @Override public Void visitPrintStmt(Stmt.Print stmt) {
        // Implementation for print statements
        return null; // Placeholder
    }

    @Override public Void visitBlockStmt(Stmt.Block stmt) {
        // Implementation for block statements
        return null; // Placeholder
    }

    @Override public Void visitIfStmt(Stmt.If stmt) {
        // Implementation for if statements
        return null; // Placeholder
    }

    @Override public Void visitCallExpr(Expr.Call expr) {
        // Implementation for call expressions
        return null; // Placeholder
    }

    @Override public Void visitVarStmt(Stmt.Var stmt) {
        // Implementation for variable declarations
        return null; // Placeholder
    }

    @Override public Object visitGroupingExpr(Expr.Grouping expr) {
        // Implementation for grouping expressions
        return null; // Placeholder
    }

    @Override public Void visitWhileStmt(Stmt.While stmt) {
        // Implementation for while statements
        return null; // Placeholder
    }

    @Override public Void visitExpressionStmt(Stmt.Expression stmt) {
        // Implementation for expression statements
        return null; // Placeholder
    }

    @Override public Void visitFunctionStmt(Stmt.Function stmt) {
        // Implementation for function statements
        return null; // Placeholder
    }

    @Override public Object visitLogicalExpr(Expr.Logical expr) {
        // Implementation for logical expressions
        return null; // Placeholder
    }

    @Override public Object visitLiteralExpr(Expr.Literal expr) {
        return expr.value;
    }


}
