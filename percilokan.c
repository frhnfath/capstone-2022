#include <stdio.h>
int main() {
	int a,b,c,i;
	scanf("%d %d %d",&a,&b,&c);
	for (i = 1; i <= a; i++)
	{
		printf("*\n");
	}
	for (i = 1; i <= b; i++)
	{
		printf(" *\n");
	}
	for (i = 1; i <= c; i++)
	{
		printf("  *\n");
	}
}