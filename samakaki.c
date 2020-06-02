#include <stdio.h>
int main() {
	int n,a,b;
	scanf("%d",&n);
	for (int i = 0; i < n; ++i)
	{
		scanf("%d",&a);
		b=a;
		for (int j = 0; j < a; ++j)
		{
			for (int k = 0; k < a-1; ++k)
			{
				printf(" ");
			}
			for (int l = 0; l < j+2; ++l)
			{
				printf("*");
			}
			printf("\n");
		}
	}
	return 0;
}