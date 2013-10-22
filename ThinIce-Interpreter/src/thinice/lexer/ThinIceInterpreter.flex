package thinice.lexer;

import java_cup.runtime.*;
import thinice.parser.ThinIceTokenDef;

%%

%public
%cupsym ThinIceTokenDef
%cup

%class ThinIceLexer
%implements ThinIceTokenDef

%line
%column
%full

%eofval{ 
	return symbol(EOF);
%eofval}

%{
	//private SimboloAbstracto nombreArchivo;
	
	public int getLinea(){
		return yyline+1;
	}
	
	public int getColumna(){
		return yycolumn+1;
	}

	private Symbol symbol(int type) {
		return new Symbol(type, yyline + 1, yycolumn + 1);
	}

	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline + 1, yycolumn + 1, value);
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

digito					=	[0-9]
NUMERO					=	{digito}+

letra					=	[a-zA-Z]
IDENTIFICADOR			=	{letra}+

BOOL					=	true|false

terminadorLinea			=	\r|\n|\r\n
caracEntrada			=	[^\r\n]
BLANCO					=	{terminadorLinea} | [ \t\f]

contenidoComentario		=	( [^*] | \*+ [^/*] )*
comentarioTradicional	=	"/*" [^*] ~"*/" | "/*" "*"+ "/"
comentarioFinDeLinea	=	"//" {caracEntrada}* {terminadorLinea}
comentarioDoc 			=	"/**" {contenidoComentario} "*"+ "/"
COMENTARIO				=	{comentarioTradicional} | {comentarioFinDeLinea} | {comentarioDoc}

conectores				=	[_.]
NOID					=	{NUMERO}(({letra}|{conectores}){digito}*)+ 
						|	{IDENTIFICADOR}(({digito}|{conectores}){letra}*)+
						|	{conectores}+(({letra}|{digito}){conectores}*)+

%%

<YYINITIAL>{

^programa				{ return symbol(PROGRAM, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
";"						{ return symbol(PUNT_C, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
","						{ return symbol(COMA, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

booleano				{ return symbol(BOOLEAN, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
entero					{ return symbol(INT, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

si						{ return symbol(IF, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
sino					{ return symbol(ELSE, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
repita					{ return symbol(DO, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
hasta					{ return symbol(WHILE, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
para					{ return symbol(FOR, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

"("						{ return symbol(PAR_I, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
")"						{ return symbol(PAR_D, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"{"						{ return symbol(LLA_I, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"}"						{ return symbol(LLA_D, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"["						{ return symbol(COR_I, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"]"						{ return symbol(COR_D, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

":="					{ return symbol(ASIG, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

"+"						{ return symbol(SUMA, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"-"						{ return symbol(RESTA, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"*"						{ return symbol(MULTI, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"/"						{ return symbol(DIV, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
mod						{ return symbol(MOD, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

Y						{ return symbol(AND, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
O						{ return symbol(OR, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"!"						{ return symbol(NOT, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

"<"						{ return symbol(MENOR, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"<="					{ return symbol(MENOR_IGUAL, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
">"						{ return symbol(MAYOR, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
">="					{ return symbol(MAYOR_IGUAL, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"="						{ return symbol(IGUAL, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
"<>"					{ return symbol(DIFERENTE, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

{NOID}					{ return symbol(ERROR,new String("["+ getLinea() + ":" + getColumna() + "] ->\t" +  yytext() + "\tERROR")); }

{BOOL}					{ return symbol(BOOLEANO, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
{NUMERO}				{ return symbol(ENTERO, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }
{IDENTIFICADOR}			{ return symbol(ID, new String("["+ getLinea() + ":" + getColumna() + "] -> " +  yytext())); }

{BLANCO}				{}
{COMENTARIO}			{}
.						{ return symbol(ERROR,new String("["+ getLinea() + ":" + getColumna() + "] ->\t" +  yytext() + "\tERROR")); }

}