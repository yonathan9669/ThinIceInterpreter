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
	private AbstractSymbol nombreArchivo;
	
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
		nombreArchivo = AbstractTable.texTabla.addSymbol(nombre, getLinea(), getColumna());
	}

	public AbstractSymbol getNombreArchivo() {
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

^programa			{ return symbol(PROGRAM,		new StringSymbol(yytext(), getLinea(), getColumna())); }
";"					{ return symbol(PUNT_C,			new StringSymbol(yytext(), getLinea(), getColumna())); }
","					{ return symbol(COMA,			new StringSymbol(yytext(), getLinea(), getColumna())); }

booleano			{ return symbol(BOOLEAN,		new Integer(AbstractSymbol.BOOLEANO)); }
entero				{ return symbol(INT,			new Integer(AbstractSymbol.ENTERO)); }

if					{ return symbol(IF,				new StringSymbol(yytext(), getLinea(), getColumna())); }
else				{ return symbol(ELSE,			new StringSymbol(yytext(), getLinea(), getColumna())); }
do					{ return symbol(DO,				new StringSymbol(yytext(), getLinea(), getColumna())); }
while				{ return symbol(WHILE,			new StringSymbol(yytext(), getLinea(), getColumna())); }
for					{ return symbol(FOR,			new StringSymbol(yytext(), getLinea(), getColumna())); }

"("					{ return symbol(PAR_I,			new StringSymbol(yytext(), getLinea(), getColumna())); }
")"					{ return symbol(PAR_D,			new StringSymbol(yytext(), getLinea(), getColumna())); }
"{"					{ return symbol(LLA_I,			new StringSymbol(yytext(), getLinea(), getColumna())); }
"}"					{ return symbol(LLA_D,			new StringSymbol(yytext(), getLinea(), getColumna())); }
"["					{ return symbol(COR_I,			new StringSymbol(yytext(), getLinea(), getColumna())); }
"]"					{ return symbol(COR_D,			new StringSymbol(yytext(), getLinea(), getColumna())); }

":="				{ return symbol(ASIG,			new StringSymbol(yytext(), getLinea(), getColumna())); }

"+"					{ return symbol(SUMA,			new StringSymbol(yytext(), getLinea(), getColumna())); }
"-"					{ return symbol(RESTA,			new StringSymbol(yytext(), getLinea(), getColumna())); }
"*"					{ return symbol(MULTI,			new StringSymbol(yytext(), getLinea(), getColumna())); }
"/"					{ return symbol(DIV,			new StringSymbol(yytext(), getLinea(), getColumna())); }
mod					{ return symbol(MOD,			new StringSymbol(yytext(), getLinea(), getColumna())); }

Y					{ return symbol(AND,			new StringSymbol(yytext(), getLinea(), getColumna())); }
O					{ return symbol(OR,				new StringSymbol(yytext(), getLinea(), getColumna())); }
"!"					{ return symbol(NOT,			new StringSymbol(yytext(), getLinea(), getColumna())); }

"<"					{ return symbol(MENOR,			new StringSymbol(yytext(), getLinea(), getColumna())); }
"<="				{ return symbol(MENOR_IGUAL,	new StringSymbol(yytext(), getLinea(), getColumna())); }
">"					{ return symbol(MAYOR,			new StringSymbol(yytext(), getLinea(), getColumna())); }
">="				{ return symbol(MAYOR_IGUAL,	new StringSymbol(yytext(), getLinea(), getColumna())); }
"="					{ return symbol(IGUAL,			new StringSymbol(yytext(), getLinea(), getColumna())); }
"<>"				{ return symbol(DIFERENTE,		new StringSymbol(yytext(), getLinea(), getColumna())); }

{NOID}				{ return symbol(ERROR,			new StringSymbol(yytext(), getLinea(), getColumna())); }

{BOOL}				{ return symbol(BOOLEANO,		AbstractTable.boolTabla.addSymbol(yytext(), getLinea(), getColumna())); }
{NUMERO}			{ return symbol(ENTERO,			AbstractTable.intTabla.addSymbol(yytext(), getLinea(), getColumna())); }
{IDENTIFICADOR}     { return symbol(ID,				AbstractTable.idTabla.addSymbol(yytext(), getLinea(), getColumna())); }

{BLANCO}			{}
{COMENTARIO}		{}
.					{ return symbol(ERROR,			new StringSymbol(yytext(), getLinea(), getColumna())); }

}