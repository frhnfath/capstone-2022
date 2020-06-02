#include <stdio.h>
int main() {
    int n,i,j,k;
    scanf("%d",&n);
    j=n;
    k=n;
    for (int i = 0; i < n; ++i)
    {
    	for (int i = 1; i < k; ++i)
    	{
    		printf(" ");
    		k++;
    	}
        for (int i = 0; i < j; ++i)
        {
            printf("*");
        }
        printf("\n");
        j--;
    }
    return 0;
}