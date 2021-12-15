grammar Calc;

prog : expr EOF;

expr : expr op expr #binaryOp
     | Num          #num
     ;

op : '+'
   | '-'
   | '/'
   | '*'
   ;

Num : [0-9]+;