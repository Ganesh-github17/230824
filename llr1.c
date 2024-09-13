#include <math.h>
#include <ctype.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int n,m=0,p,i=0,j=0;
char r[10][10],f[10];
void follow(char c );
void first(char c);
int main() {
int i,z;
char c,ch;
printf("Enter the no of productions : \n");
scanf("%d",&n);
printf("Enter the productions : \n");
for(i=0;i<n;i++)
scanf("%s%c",r[i],&ch);
do {
m=0;
printf("Enter the elements whole first and follow is to be found : ");
scanf("%c",&c);
first(c);
printf("first(%c)={",c);
for (i=0;i<m;i++)
printf("%c",f[i]);
printf("}\n");
strcpy(f,"");
//flush all();
m=0;
follow(c);
printf("Follow(%c)={",c);
for(i=0;i<m;i++)
printf("%c",f[i]);
printf("}\n");
printf("Continue (0/1)?");
scanf("%d%c",&z,&ch);
}while(z==1);
return(0);
}
void first(char c)
{
int k;
if(!isupper(c))
f[m++]=c;
for(k=0;k<n;k++)
{
if(r[k][0]==c)
{
if(r[k][2]=='$')
follow(r[k][0]);
else if (islower(r[k][2]))
f[m++]=r[k][2];
else first(r[k][2]);
}
}
}
void follow(char c)
{
if(r[0][0]==c)
f[m++]='$';
for (i=0;i<n;i++)
{
for(j=2;j<strlen(r[i]);j++)
{
if (r[i][j]==c)
{
if(r[i][j+1]!='\0')
first(r[i][j+1]);
if (r[i][j+1]=='\0'&&c!=r[i][0])
follow(r[i][0]);
}
}
}}


