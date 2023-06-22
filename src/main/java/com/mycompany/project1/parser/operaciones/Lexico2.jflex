
package com.mycompany.project1.parser.operaciones;
import com.mycompany.project1.parser.Token;
import static com.mycompany.project1.parser.operaciones.ParserSym.*;
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
    private Symbol token(int Type){
        return new Symbol(Type,new Token(yyline+1,yycolumn+1,Type));
    }
    private Symbol token(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }
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
{Id}		{return token(ID,new String(yytext()));}
{Integer}	{return token(INT,new Integer(yytext()));}
{Decimal}	{return token(FLOAT,new Double(yytext()));}
{WhiteSpace}    {/*IGNORAR*/}
{String}        {return token(STRING,new String(yytext()));}

"+"		{return token(ADD);}
"-"		{return token(MENOS);}
"*"		{return token(MULT);}
[^]		{Errores +=  "\n" + "Simbolo no reconocido: " + yytext() + " linea: " + (yyline+1);}
