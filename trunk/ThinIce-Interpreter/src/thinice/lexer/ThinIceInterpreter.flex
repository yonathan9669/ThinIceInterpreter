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

^programa		{ return new Symbol(PROGRAM); }
";"				{ return new Symbol(PUNT_C); }

booleano 		{ return new Symbol(BOOL); }
entero  		{ return new Symbol(INT); }

si				{ return new Symbol(IF); }
sino			{ return new Symbol(ELSE); }
repita			{ return new Symbol(DO); }
hasta			{ return new Symbol(WHILE); }
para			{ return new Symbol(FOR); }

"("				{ return new Symbol(PAR_I); }
")"				{ return new Symbol(PAR_D); }
"{"				{ return new Symbol(LLA_I); }
"}"				{ return new Symbol(LLA_D); }
"["				{ return new Symbol(COR_I); }
"]"				{ return new Symbol(COR_D); }

":="			{ return new Symbol(ASIG); }

"+"				{ return new Symbol(SUMA); }
"-"				{ return new Symbol(RESTA); }
"*"				{ return new Symbol(MULTI); }
"/"				{ return new Symbol(DIV); }
mod				{ return new Symbol(MOD); }

Y				{ return new Symbol(AND); }
O				{ return new Symbol(OR); }
"!"				{ return new Symbol(NOT); }

"<"				{ return new Symbol(MENOR); }
"<="			{ return new Symbol(MENOR_IGUAL); }
">"				{ return new Symbol(MAYOR); }
">="			{ return new Symbol(MAYOR_IGUAL); }
"="				{ return new Symbol(IGUAL); }
"<>"			{ return new Symbol(DIFERENTE); }

true|false		{ return new Symbol(BOOLEANO, new Boolean(yytext()); }
[0-9]+			{ return new Symbol(ENTERO, new Integer(yytext())); }
[a-zA-Z_]+		{ return new Symbol(ID, new String(yytext())); }

{BLANCO}		{}
{COMENTARIO}	{}
.				{ return new Symbol(ERROR, new SimboloTexto(yytext(), getLinea(), getColumna())); }

}