import static com.mycompany.server.parser.ParserSym.*;
import java_cup.runtime.Symbol;
%%
%class Lexer
%unicode
%line
%column
%type java_cup.runtime.Symbol
%cup

//Java code
%{
	
    private Symbol token(int type,String Value){
        return new Symbol(type, new Token(Value,yyline+1,yycolumn+1,type));
    }

    private Symbol token(int Type){
        return new Symbol(Type,new Token(yyline+1,yycolumn+1,Type));
    }
%}


//Regular expressions
Id 		= [:jletter:] [:jletterdigit:]*
Integer 	= 0 | [1-9][0-9]*
Decimal 	= {Integer}\.\d+


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

{Id}		{return token(ID,yytext());}
{Integer}	{return token(INT,yytext());}
{Decimal}	{return token(FLOAT,yytext());}

")"		{return token(PAREN_O);}
";"             {return token(PCOMA);}
"("		{return token(PAREN_C);}
"+"		{return token(ADD);}
"-"		{return token(MENOS);}
"*"		{return token(MULT);}
":="		{return token(IGUAL);}
"="             {return token(IGUALC);}
">"		{return token(MAYOR);}
"<"		{return token(MENOR);}
"\""		{return token(COMILLA);}
[^]		{System.out.println("Error con : " + yytext());}
