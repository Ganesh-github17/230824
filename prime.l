%{
#include<stdio.h>
int m;
%}
%%
[0-9]* {m=atoi(yytext);
if(m%2 ==0)
printf("even");
else
printf("odd");
}
%%
int yywrap() {};
int main()
{
printf("enter a number");
yylex();
return 0;
}
       
             
           
             
