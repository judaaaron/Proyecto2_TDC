grammar Calc;

prog : expr EOF;

expr : expr op expr
     | Num
     ;

op : '+'
   | '-'
   | '/'
   | '*'
   ;

Num : [0-9]+;