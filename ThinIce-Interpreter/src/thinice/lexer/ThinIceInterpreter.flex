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

^programa			{ return symbol(PROGRAM,		new SimboloTexto(yytext(), getLinea(), getColumna())); }
";"					{ return symbol(PUNT_C,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
","					{ return symbol(COMA,			new SimboloTexto(yytext(), getLinea(), getColumna())); }

booleano			{ return symbol(BOOLEAN,		new SimboloTexto(yytext(), getLinea(), getColumna(), SimboloAbstracto.BOOLEANO)); }
entero				{ return symbol(INT,			new SimboloTexto(yytext(), getLinea(), getColumna(), SimboloAbstracto.ENTERO)); }

if					{ return symbol(IF,				new SimboloTexto(yytext(), getLinea(), getColumna())); }
else				{ return symbol(ELSE,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
do					{ return symbol(DO,				new SimboloTexto(yytext(), getLinea(), getColumna())); }
while				{ return symbol(WHILE,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
for					{ return symbol(FOR,			new SimboloTexto(yytext(), getLinea(), getColumna())); }

"("					{ return symbol(PAR_I,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
")"					{ return symbol(PAR_D,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
"{"					{ return symbol(LLA_I,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
"}"					{ return symbol(LLA_D,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
"["					{ return symbol(COR_I,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
"]"					{ return symbol(COR_D,			new SimboloTexto(yytext(), getLinea(), getColumna())); }

":="				{ return symbol(ASIG,			new SimboloTexto(yytext(), getLinea(), getColumna())); }

"+"					{ return symbol(SUMA,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
"-"					{ return symbol(RESTA,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
"*"					{ return symbol(MULTI,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
"/"					{ return symbol(DIV,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
mod					{ return symbol(MOD,			new SimboloTexto(yytext(), getLinea(), getColumna())); }

Y					{ return symbol(AND,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
O					{ return symbol(OR,				new SimboloTexto(yytext(), getLinea(), getColumna())); }
"!"					{ return symbol(NOT,			new SimboloTexto(yytext(), getLinea(), getColumna())); }

"<"					{ return symbol(MENOR,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
"<="				{ return symbol(MENOR_IGUAL,	new SimboloTexto(yytext(), getLinea(), getColumna())); }
">"					{ return symbol(MAYOR,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
">="				{ return symbol(MAYOR_IGUAL,	new SimboloTexto(yytext(), getLinea(), getColumna())); }
"="					{ return symbol(IGUAL,			new SimboloTexto(yytext(), getLinea(), getColumna())); }
"<>"				{ return symbol(DIFERENTE,		new SimboloTexto(yytext(), getLinea(), getColumna())); }

{NOID}				{ return symbol(ERROR,			new SimboloTexto(yytext(), getLinea(), getColumna())); }

{BOOL}				{ return symbol(BOOLEANO,		TablaAbstracta.boolTabla.agregarSimbolo(yytext(), getLinea(), getColumna())); }
{NUMERO}			{ return symbol(ENTERO,			TablaAbstracta.intTabla.agregarSimbolo(yytext(), getLinea(), getColumna())); }
{IDENTIFICADOR}     { return symbol(ID,				TablaAbstracta.idTabla.agregarSimbolo(yytext(), getLinea(), getColumna())); }

{BLANCO}			{}
{COMENTARIO}		{}
.					{ return symbol(ERROR,			new SimboloTexto(yytext(), getLinea(), getColumna())); }

}