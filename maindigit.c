#include <stdio.h>
int main() {
	int a=1,b,c=0;
	int m,n,x,y;
	scanf("%d",&m);
	for (int i = 0; i < m; ++i)
	{
		scanf("%d %d %d",&n,&x,&y);
		if (x>n) break;
		for (int j=0; j < n;j++){ 
			b=a*x;
			if (b>=n) break;
			if (c>0 && (b%y)!=0) printf(" ");
			if (b%y==0) b=b;
			else printf("%d",b);		
			a++;
			c++;
		}
		printf("\n");
		a=1;
		c=0;
	}
	return 0;
}