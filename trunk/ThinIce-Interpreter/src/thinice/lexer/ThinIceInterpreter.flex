package thinice.lexer;

import java_cup.runtime.*;
import thinice.parser.*;

%%
%{
	//private SimboloAbstracto nombreArchivo;
	
	public int getLinea(){
		return yyline+1;
	}
	
	public int getColumna(){
		return yycolumn+1;
	}

        /*
        public void setNombreArchivo(String nombre) {
		nombreArchivo = TablaAbstracta.texTabla.agregarSimbolo(nombre, getLinea(), getColumna());
        }

        public SimboloAbstracto getNombreArchivo() {
		return nombreArchivo;
        }
        */
%}

%public
%class ThinIceLexer
%implements ThinIceTokenDef
%line
%column
%cup
%notunix
%full

BLANCO = [ \n\r\t]
COMENTARIO = "{"[^}]*"}"

%%
<YYINITIAL>{

^programa		{ return new Symbol(PROGRAMA); }
";" 			{ return new Symbol(PCOMA); }

boolean 		{ return new Symbol(TIPOBOOL); }
entero  		{ return new Symbol(TIPOENTERO); }

si 			{ return new Symbol(SI); }
sino 			{ return new Symbol(SINO); }
repita  		{ return new Symbol(REPITA); }
hasta   		{ return new Symbol(HASTA); }
para 			{ return new Symbol(PARA); }

"(" 			{ return new Symbol(PAR_IZ); }
")" 			{ return new Symbol(PAR_DE); }
"{" 			{ return new Symbol(LLA_IZ); }
"}" 			{ return new Symbol(LLA_DE); }
"[" 			{ return new Symbol(COR_IZ); }
"]" 			{ return new Symbol(COR_DE); }

":=" 			{ return new Symbol(ASIGNA); }

"+" 			{ return new Symbol(OP_SUMA); }
"-" 			{ return new Symbol(OP_RESTA); }
"*" 			{ return new Symbol(OP_MULTI); }
"/" 			{ return new Symbol(OP_DIVI); }
mod 			{ return new Symbol(OP_MODU); }

Y 			{ return new Symbol(OP_CONJ); }
O 			{ return new Symbol(OP_DISJ); }
"!" 			{ return new Symbol(OP_NEG); }

"<" 			{ return new Symbol(MENOR); }
"<=" 			{ return new Symbol(MENOR_IGUAL); }
">" 			{ return new Symbol(MAYOR); }
">=" 			{ return new Symbol(MAYOR_IGUAL); }
"=" 			{ return new Symbol(IGUAL); }
"<>" 			{ return new Symbol(DIFERENTE); }

true|false		{ return new Symbol(BOOL, new Boolean(yytext()); }
[0-9]+			{ return new Symbol(ENTERO, new Integer(yytext())); }
[a-zA-Z_]+		{ return new Symbol(ID, new String(yytext())); }

{BLANCO}		{}
{COMENTARIO}            {}
.			{ return new Symbol(ERROR, new SimboloTexto(yytext(), getLinea(), getColumna())); }

}