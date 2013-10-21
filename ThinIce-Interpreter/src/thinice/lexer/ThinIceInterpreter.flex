package thinice.lexer;

import java_cup.runtime.*;
import JFlex.sym;
import thinice.parser.ThinIceTokenDef;

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

BLANCO = [ \n\r\t]
COMENTARIO = "{"[^}]*"}"

%%
<YYINITIAL>{

^programa		{ return new Symbol(PROGRAM, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
";"				{ return new Symbol(PUNT_C, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

booleano 		{ return new Symbol(BOOL, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
entero  		{ return new Symbol(INT, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

si				{ return new Symbol(IF, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
sino			{ return new Symbol(ELSE, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
repita			{ return new Symbol(DO, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
hasta			{ return new Symbol(WHILE, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
para			{ return new Symbol(FOR, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

"("				{ return new Symbol(PAR_I, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
")"				{ return new Symbol(PAR_D, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"{"				{ return new Symbol(LLA_I, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"}"				{ return new Symbol(LLA_D, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"["				{ return new Symbol(COR_I, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"]"				{ return new Symbol(COR_D, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

":="			{ return new Symbol(ASIG, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

"+"				{ return new Symbol(SUMA, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"-"				{ return new Symbol(RESTA, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"*"				{ return new Symbol(MULTI, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"/"				{ return new Symbol(DIV, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
mod				{ return new Symbol(MOD, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

Y				{ return new Symbol(AND, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
O				{ return new Symbol(OR, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"!"				{ return new Symbol(NOT, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

"<"				{ return new Symbol(MENOR, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"<="			{ return new Symbol(MENOR_IGUAL, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
">"				{ return new Symbol(MAYOR, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
">="			{ return new Symbol(MAYOR_IGUAL, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"="				{ return new Symbol(IGUAL, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"<>"			{ return new Symbol(DIFERENTE, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

true|false		{ return new Symbol(BOOLEANO, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
[0-9]+			{ return new Symbol(ENTERO, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
[a-zA-Z_]+		{ return new Symbol(ID, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

{BLANCO}		{}
{COMENTARIO}	{}
.				{ return new Symbol(ERROR,new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

}