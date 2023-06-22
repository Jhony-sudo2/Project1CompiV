package com.mycompany.project1.parser;
import static com.mycompany.project1.parser.ParserSym.*;
import java_cup.runtime.Symbol;
%%
%class Lexer2
%public
%unicode
%line
%column
%cup

//Java code
%{
%}

%eofval{
    return token(EOF);
%eofval}
%eofclose

//Regular expressions
Id 		= [:jletter:] [:jletterdigit:]*
Integer 	= 0 | [1-9][0-9]*
Decimal 	= {Integer}\.\d+
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
String		= "\"" [^*] ~"\"" 

/*Actions*/
%%
{Id}		{return symbol(ID, yytext());}
{Integer}	{return symbol(INT, new Integer(yytext()));}
{Decimal}	{return symbol(FLOAT,new Double(yytext()));}
{WhiteSpace}    {/*IGNORAR*/}
{String}        {return symbol(STRING,new String(yytext()));}

"+"		{return symbol(ADD);}
"-"		{return symbol(MENOS);}
"*"		{return symbol(MULT);}
[^]		{Errores +=  "\n" + "Simbolo no reconocido: " + yytext() + " linea: " + (yyline+1);}
