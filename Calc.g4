grammar Calc;

start : expr EOF;

expr : expr op expr # binaryOp 
     | Num          # num
     ;


op : '+'
   | '-'
   | '/'
   | '*'
   ;

Num : [0-9]+;