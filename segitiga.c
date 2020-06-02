#include <stdio.h>
int main(){
	int n,i,j;
	scanf("%d",&n);
	for (int i = 0; i < n; ++j)
	{
		for (int j  = 0; j < n; ++j)
		{
			printf("*");
		}
		n--;
		printf("\n");
	}
	return 0;
}