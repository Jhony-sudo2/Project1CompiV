package com.mycompany.project1.parser;
import static com.mycompany.project1.parser.ParserSym.*;
import java_cup.runtime.Symbol;
%%
%class Lexer
%public
%unicode
%line
%column
%cup

//Java code
%{
    /*
    private Symbol token(int type,String Value){
        return new Symbol(type, new Token(Value,yyline+1,yycolumn+1,type));
    }*/

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
(Entero)	{return token(ENTERO);}
(Leer)          {return token(LEER);}
(Escribir)	{return token(ESCRIBIR);}
(Mientras)	{return token(MIENTRAS);}
(Cadena)	{return token(CADENA);}
(Decimal)	{return token(DECIMAL);}
(SI)		{return token(SI);}
(SINO)		{return token(SINO);}
(Para)		{return token(PARA);}
{Id}		{return token(ID,new String(yytext()));}
{Integer}	{return token(INT,new Integer(yytext()));}
{Decimal}	{return token(FLOAT,new Double(yytext()));}
{WhiteSpace}    {/*IGNORAR*/}
{String}        {return token(STRING,new String(yytext()));}

")"		{return token(PAREN_C);}
";"             {return token(PCOMA);}
","             {return token(COMA);}
"("		{return token(PAREN_O);}
"+"		{return token(ADD);}
"-"		{return token(MENOS);}
"*"		{return token(MULT);}
":="		{return token(IGUAL);}
"="		{return token(IGUALC);}
">"		{return token(MAYOR);}
">="            {return token(MAYORIG);}
"<="            {return token(MENORIG);}
"<"		{return token(MENOR);}
"!="            {return token(DIFERENTE);}
[^]		{System.out.println("Error con : " + yytext());}
