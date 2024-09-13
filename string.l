%{
#include<stdio.h>
int m;
%}
%%
[a-z A-Z 0-9]+ {m=yyleng;}
 [\n]  {printf("the length of string is %d",m);}
%%
int yywrap() {};
int main()
{
printf("enter a string");
yylex();
return 0;
}
