#include <stdio.h>
int main() {
	int a=1,b,c=1,n,m;
	scanf("%d",&n);
	for (int i = 0; i < n; ++i)
	{
		a=1;
		scanf("%d",&m);
		b=m;
		for (int j = 0; j < m; ++j)
		{
			for (int k = 0; k < b; ++k)
			{
				printf("*");
			}
			b--;
			printf("\n");
			for (int i = 0; i < a; ++i)
			{
				if (b==0) break;
				printf(" ");
			}
			a++;
		}
		for (int i = 0; i < a-2; ++i)
		{
			printf(" ");
		}
		b++;
		for (int ii = 0; ii < m-1; ++ii)
		{
			b++;
			for (int ij = 0; ij < b; ++ij)
			{
				printf("*");
			}
			if ((c-b)==n) break;
			printf("\n");
			if (b==m) break;
			for (int ik = 0; ik < a-2; ++ik)
			{
				printf(" ");
			}
		}
		if (c==n) break;
		printf("\n");
		c++;
	}return 0;
}