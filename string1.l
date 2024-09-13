%{
#include<stdio.h>
#include<string.h>
int k=0,sc=0,ch=0,wc=0,tc=0,l=0;
%}
%%


[\n] {k++;ch+=yyleng;}
[ ] {sc++;ch+=yyleng;}
[\t] {tc++;ch+=yyleng;}
[^\t\n]+ {wc++;ch+=yyleng;}  
%%
int yywrap()
{return 1;}
int main()
{
printf("enter the sentence:");
yylex();
printf("no of lines %d\n",l);
printf("no of spaces %d\n",sc);
printf("no of words %d\n",wc);
printf("no of characters %d\n",ch);
printf("no of tabs %d",tc);
return 0;
}
