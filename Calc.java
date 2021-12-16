import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Calc {
    public static void main(String[] args) throws Exception {
        ANTLRFileStream str = new ANTLRFileStream(args[0]);
        CalcLexer lex = new CalcLexer(str);
        CommonTokenStream tok = new CommonTokenStream(lex);

        CalcParser parser = new CalcParser(tok);
        ParseTree tree = parser.start();

        System.out.println(new MyVisitor().visit(tree));
    }
}

class MyVisitor extends CalcBaseVisitor<Integer> {
    @Override
    public Integer visitStart(CalcParser.StartContext ctx) {

        return visit(ctx.expr());
    }

    @Override
    public Integer visitBinaryOp(CalcParser.BinaryOpContext ctx) {
        int lhs = visit(ctx.expr(0));
        int rhs = visit(ctx.expr(1));

        String op = ctx.op().getText();
        int resultado = 0;
        if (op.equals("+")) {
            resultado = lhs + rhs;
        } else if (op.equals("-")) {
            resultado = lhs - rhs;
        } else if (op.equals("/")) {
            resultado = lhs / rhs;
        } else if (op.equals("*")) {
            resultado = lhs * rhs;
        }

        return resultado;
    }

    @Override
    public Integer visitNum(CalcParser.NumContext ctx) {
        return Integer.parseInt(ctx.Num().getText());

    }

    @Override
    public Integer visitOp(CalcParser.OpContext ctx) {
        return visitChildren(ctx);
    }
}