// Generated from Calc.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CalcParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CalcParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryOp}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(CalcParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryOp}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(CalcParser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNum(CalcParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNum(CalcParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(CalcParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(CalcParser.OpContext ctx);
}