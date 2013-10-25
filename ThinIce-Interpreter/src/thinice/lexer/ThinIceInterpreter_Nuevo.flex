package thinice.lexer;

import java_cup.runtime.*;
import thinice.parser.ThinIceTokenDef;
import thinice.TS.*;

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
	private SimboloAbstracto nombreArchivo;
	
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
	
    
	public void setNombreArchivo(String nombre) {
		nombreArchivo = TablaAbstracta.texTabla.agregarSimbolo(nombre, getLinea(), getColumna());
	}

	public SimboloAbstracto getNombreArchivo() {
		return nombreArchivo;
	}
	
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

^programa			{ return new Symbol(PROGRAM,        new SimboloTexto(yytext(), getLinea(), getColumna())); }
";"					{ return new Symbol(PUNT_C,         new SimboloTexto(yytext(), getLinea(), getColumna())); }
","					{ return new Symbol(COMA,           new SimboloTexto(yytext(), getLinea(), getColumna())); }

booleano			{ return new Symbol(BOOLEAN,        new SimboloTexto(yytext(), getLinea(), getColumna())); }
entero				{ return new Symbol(INT,            new SimboloTexto(yytext(), getLinea(), getColumna())); }

si					{ return new Symbol(IF,             new SimboloTexto(yytext(), getLinea(), getColumna())); }
sino				{ return new Symbol(ELSE,           new SimboloTexto(yytext(), getLinea(), getColumna())); }
repita				{ return new Symbol(DO,             new SimboloTexto(yytext(), getLinea(), getColumna())); }
hasta				{ return new Symbol(WHILE,          new SimboloTexto(yytext(), getLinea(), getColumna())); }
para				{ return new Symbol(FOR,            new SimboloTexto(yytext(), getLinea(), getColumna())); }

"("					{ return new Symbol(PAR_I,          new SimboloTexto(yytext(), getLinea(), getColumna())); }
")"					{ return new Symbol(PAR_D,          new SimboloTexto(yytext(), getLinea(), getColumna())); }
"{"					{ return new Symbol(LLA_I,          new SimboloTexto(yytext(), getLinea(), getColumna())); }
"}"					{ return new Symbol(LLA_D,          new SimboloTexto(yytext(), getLinea(), getColumna())); }
"["					{ return new Symbol(COR_I,          new SimboloTexto(yytext(), getLinea(), getColumna())); }
"]"					{ return new Symbol(COR_D,          new SimboloTexto(yytext(), getLinea(), getColumna())); }

":="				{ return new Symbol(ASIG,           new SimboloTexto(yytext(), getLinea(), getColumna())); }

"+"					{ return new Symbol(SUMA,           new SimboloTexto(yytext(), getLinea(), getColumna())); }
"-"					{ return new Symbol(RESTA,          new SimboloTexto(yytext(), getLinea(), getColumna())); }
"*"					{ return new Symbol(MULTI,          new SimboloTexto(yytext(), getLinea(), getColumna())); }
"/"					{ return new Symbol(DIV,            new SimboloTexto(yytext(), getLinea(), getColumna())); }
mod					{ return new Symbol(MOD,            new SimboloTexto(yytext(), getLinea(), getColumna())); }

Y					{ return new Symbol(AND,            new SimboloTexto(yytext(), getLinea(), getColumna())); }
O					{ return new Symbol(OR,             new SimboloTexto(yytext(), getLinea(), getColumna())); }
"!"					{ return new Symbol(NOT,            new SimboloTexto(yytext(), getLinea(), getColumna())); }

"<"					{ return new Symbol(MENOR,          new SimboloTexto(yytext(), getLinea(), getColumna())); }
"<="				{ return new Symbol(MENOR_IGUAL,    new SimboloTexto(yytext(), getLinea(), getColumna())); }
">"					{ return new Symbol(MAYOR,          new SimboloTexto(yytext(), getLinea(), getColumna())); }
">="				{ return new Symbol(MAYOR_IGUAL,    new SimboloTexto(yytext(), getLinea(), getColumna())); }
"="					{ return new Symbol(IGUAL,          new SimboloTexto(yytext(), getLinea(), getColumna())); }
"<>"				{ return new Symbol(DIFERENTE,      new SimboloTexto(yytext(), getLinea(), getColumna())); }

{NOID}				{ return new Symbol(ERROR,          new SimboloTexto(yytext(), getLinea(), getColumna())); }

{BOOL}				{ return new Symbol(BOOLEANO,       TablaAbstracta.boolTabla.agregarSimbolo(yytext(), getLinea(), getColumna())); }
{NUMERO}			{ return new Symbol(ENTERO,         TablaAbstracta.intTabla.agregarSimbolo(yytext(), getLinea(), getColumna())); }
{IDENTIFICADOR}     { return new Symbol(ID,             TablaAbstracta.idTabla.agregarSimbolo(yytext(), getLinea(), getColumna())); }

{BLANCO}			{}
{COMENTARIO}		{}
.					{ return new Symbol(ERROR,          new SimboloTexto(yytext(), getLinea(), getColumna())); }

}