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
            System.out.println("Menu ");
            System.out.println("1. Realizar operaciones aritmeticas");
            System.out.println("2. Mostrar Parse Tree");
            System.out.println("3. Salir");
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
                    ANTLRFileStream str = new ANTLRFileStream("./test.calc");
                    CalcLexer lex = new CalcLexer(str);
                    CommonTokenStream tok = new CommonTokenStream(lex);

                    CalcParser parser = new CalcParser(tok);
                    ParseTree tree = parser.prog();

                    System.out.println(tree);
                    break;
                }

                case 2: {
                    try {
                        String arbol = "cmd /c start cmd.exe /K \"grun Calc prog " + input + " -gui";
                        Runtime.getRuntime().exec(arbol);

                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;

                }

                case 3: {
                    control = false;
                    break;
                }
            }
        }

    }
}

// class MyVisitor extends CalcBase<Integer> {

// @Override
// public Integer visitProg(CalcParser.ProgContext ctx) {
// return visitChildren(ctx);
// }

// @Override
// public Integer visitBinaryOp(CalcParser.BinaryOpContext ctx) {
// return visitChildren(ctx);
// }

// @Override
// public Integer visitNum(CalcParser.NumContext ctx) {
// return Integer.parseInt(ctx.Num().getText());
// }

// @Override
// public Integer visitOp(CalcParser.OpContext ctx) {
// return visitChildren(ctx);
// }
// }
