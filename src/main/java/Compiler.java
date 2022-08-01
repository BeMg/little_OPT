import java.lang.*;

public class Compiler {
    public static void main(String[] args)
    {
        test1();
        test2();
    }

    static void test2() {
        ASTParser p = new ASTParser();
        ASTNode t1 = p.parse("FUNCTION(FUNCNAME(add),ARGS(VAR(x),VAR(y)),STATEMENT(RETURN(ADD(VAR(x),VAR(y)))))");
        ASTCompiler c = new ASTCompiler();
        Function f = c.compile(t1);
        f.dump();
}

    static void test1() {
        ASTParser p = new ASTParser();
        ASTNode t1 = p.parse("FUNCTION()");
        ASTNode t2 = p.parse("FUNCTION(FUNCNAME(add),ARGS(VAR(x),VAR(y)),STATEMENT(RETURN(ADD(VAR(x),VAR(y)))))");
        ASTNode t3 = p.parse("FUNCTION(FUNCNAME(add),ARGS(VAR(x),VAR(y)))");
    }
}

