package thinice.especificaciones;
import java_cup.runtime.Symbol;

%%

%cup
%notunix
%full

%%
^programa		{ return new Symbol(sym.PROGRAMA); }
";" 			{ return new Symbol(sym.PCOMA); }
"+" 			{ return new Symbol(sym.OP_SUMA); }
"-" 			{ return new Symbol(sym.OP_RESTA); }
"*" 			{ return new Symbol(sym.OP_MULTI); }
"/" 			{ return new Symbol(sym.OP_DIVI); }
"mod" 			{ return new Symbol(sym.OP_MODU); }
":=" 			{ return new Symbol(sym.ASIGNA); }
"Y" 			{ return new Symbol(sym.OP_CONJ); }
"O" 			{ return new Symbol(sym.OP_DISJ); }
"!" 			{ return new Symbol(sym.OP_NEG); }
"<" 			{ return new Symbol(sym.MENOR); }
"<=" 			{ return new Symbol(sym.MENOR_IGUAL); }
">" 			{ return new Symbol(sym.MAYOR); }
">=" 			{ return new Symbol(sym.MAYOR_IGUAL); }
"=" 			{ return new Symbol(sym.IGUAL); }
"<>" 			{ return new Symbol(sym.DIFERENTE); }
"(" 			{ return new Symbol(sym.PAR_IZ); }
")" 			{ return new Symbol(sym.PAR_DE); }
"{" 			{ return new Symbol(sym.LLA_IZ); }
"}" 			{ return new Symbol(sym.LLA_DE); }
"[" 			{ return new Symbol(sym.COR_IZ); }
"]" 			{ return new Symbol(sym.COR_DE); }
"si" 			{ return new Symbol(sym.SI); }
"sino" 			{ return new Symbol(sym.SINO); }
"repita" 		{ return new Symbol(sym.REPITA); }
"hasta" 		{ return new Symbol(sym.HASTA); }
"para" 			{ return new Symbol(sym.PARA); }
boolean			{ return new Symbol(sym.TIPOBOOL); }
entero			{ return new Symbol(sym.TIPOENTERO); }
true			{ return new Symbol(sym.BOOL,new Boolean(true)); }
false			{ return new Symbol(sym.BOOL,new Boolean(false)); }
[0-9]+			{ return new Symbol(sym.ENTERO,new Integer(yytext())); }
[a-zA-Z]+		{ return new Symbol(sym.ID,new String(yytext())); }
[\n\r ]+		{ }