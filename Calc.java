import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Calc{
    public static void main(String[] args) {
        ANTLRFileStream str = ANTLRFileStream(args[0]);
        CalcLexer lex = new CalcLexer(str);
        CommonTokenStream tok = new CommonTokenStream(lex);

        CalcParser tree = parser.start();

        System.out.println(new MyVisitor().visit(tree));
    }
}
