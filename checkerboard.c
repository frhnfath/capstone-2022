#include <stdio.h>
int main(){
	int n,a=0;
	scanf("%d",&n);
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= n; ++j)
		{
			printf("%d", a);
			if (a==0) a=1;
			else if (a==1) a=0;
			if (j!=n) printf(" ");
		}
		printf("\n");
		if (n%2==0) {
			if (a%2==0) a=1;
			else a=0;
		}
	}
	return 0;
}