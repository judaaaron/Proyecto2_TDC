import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Calc {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String cadena;
        System.out.println("Ingrese operaciones aritmeticas: ");
        cadena = leer.next();
        String input = "./test.calc";
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(input, false);
            pw = new PrintWriter(fichero);
            pw.write(cadena);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        ANTLRFileStream str = new ANTLRFileStream(input);
        CalcLexer lex = new CalcLexer(str);
        CommonTokenStream tok = new CommonTokenStream(lex);

        CalcParser parser = new CalcParser(tok);
        ParseTree tree = parser.prog();

        System.out.println(new MyVisitor().visit(tree));
    }
}

class MyVisitor extends CalcBaseVisitor<Integer> {

    @Override
    public Integer visitProg(CalcParser.ProgContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitBinaryOp(CalcParser.BinaryOpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitNum(CalcParser.NumContext ctx) {
        System.out.println(ctx.Num().getText());
        return visitChildren(ctx);
    }

    @Override
    public Integer visitOp(CalcParser.OpContext ctx) {
        return visitChildren(ctx);
    }
}
