#include <stdio.h>
int main() {
	int x,y,a,b,e=1,n=9,c,d,f,g;
	scanf("%d %d",&x,&y);
	a=x*y;
	for (int j = 0; j < x; ++j)
	{
		for (int i = 0; i < y; ++i)
		{
			scanf("%d",&b);
			if (b<n) {
				c=i;
				d=j;
				b=n;
			}
			if (b>e) {
				e=b;
				f=i;
				g=j;
			}
		}
	}
	printf("%d %d\n%d %d\n",c,d,e,f);
}