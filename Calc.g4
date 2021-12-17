grammar Calc;
	
start : expr EOF;

expr:	expr signos = ('*'|'/') expr # binaryOp
    |	expr signos = ('+'|'-') expr # binaryOp
    |	Num # num
    ;

Num     : [0-9]+ ;