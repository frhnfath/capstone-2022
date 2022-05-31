#include <stdio.h>
int main() {
	int n,a,b;
	scanf("%d",&n);
	a=0;b=n;
	for (int i = 0; i < n; ++i)
	{
		for (int k = 0; k < a; ++k)
		{
			printf(" ");
		}
		for (int j = 0; j < b; ++j)
		{
			printf("*");
		}
		printf("\n");
		a+=1;b-=1;
	}
}