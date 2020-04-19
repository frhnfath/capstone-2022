#include <stdio.h>
int main() {
	int a,b,n;
	n=0;
	scanf("%d %d",&a,&b);
	for (int i = 1; i <= a; i++)
	{
		for (int j = 1; j <= b; j++)
		{
			printf("%d",n);
			n++;
			if (j!=b) printf(" ");
			if (n>9) n=0;
		}
		printf("\n");
	}
	return 0;
}