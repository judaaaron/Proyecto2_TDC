grammar Calc;
	
start : expr EOF;

expr:	expr signos = ('*'|'/') expr # operador
    |	expr signos = ('+'|'-') expr # operador
    |	Num # num
    ;

Num     : [0-9]+ ;