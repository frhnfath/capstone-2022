#include <stdio.h>
int main() {
	int n,x,y,c=1;
	scanf("%d",&n);
	for (int i = 0; i < n; ++i)
	{
		scanf("%d %d",&y,&x);
		for (int j = 0; j < x; ++j)
		{
			printf("*");
		}
		printf("\n");
		if (x==1) {
			for (int k = 0; k < y-1; ++k)
			{
				printf("*\n");
			}
		}
		else if (y>2 && x>1) {
			for (int l = 0; l < y-2; ++l)
			{
				printf("*");
				for (int m = 0; m < x-2; ++m)
				{
					printf(".");
				}
				printf("*");
				printf("\n");
			}
			for (int ij = 0; ij < x; ++ij)
			{
				printf("*");
			}
			printf("\n");
		}
		else if (y==2) {
				for (int ik = 0; ik < x; ++ik)
			{
				printf("*");
			}
			printf("\n");
		}
		if (c==n) break;
		printf("\n");
		c++;
	}

}