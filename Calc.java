import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Calc {
    static Scanner leer = new Scanner(System.in);
    static String input = "./test.calc";

    public static void main(String[] args) throws Exception {
        boolean control = true;
        while (control == true) {
            System.out.println("---Calculadora basica---");
            System.out.println("1. Realizar operaciones aritmeticas");
            System.out.println("2. Salir");
            int op = leer.nextInt();

            switch (op) {
                case 1: {

                    String cadena;
                    System.out.println("Ingrese operaciones aritmeticas: ");
                    cadena = leer.next();

                    FileWriter archivo = null;
                    PrintWriter pw = null;
                    try {
                        archivo = new FileWriter(input, false);
                        pw = new PrintWriter(archivo);
                        pw.write(cadena);

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {

                            if (null != archivo)
                                archivo.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }

                    System.out.print("El resultado es de: ");
                    aritmetica(args[0]);
                    System.out.println();
                    System.out.println("Mostrando parse tree...");
                    try {
                        Thread.sleep(5000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println();
                    try {
                        String arbol = "cmd /c start cmd.exe /K \"grun Calc start " + input + " -gui";
                        Runtime.getRuntime().exec(arbol);

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                }

                case 2: {

                    control = false;
                    break;

                }

            }

        }

    }

    public static void aritmetica(String args) throws Exception {
        ANTLRFileStream str = new ANTLRFileStream(args);
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