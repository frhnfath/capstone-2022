#include <stdio.h>
int main() {
	int i,n,a,b,c,d,result;
	scanf("%d",&n);
	a=0;
	b=0;
	c=100000000;
	d=0;
	for (int i = 1; i <= n; i++)
	{
		scanf ("%d", &a);
		if (a<0){
			if (a<b) b=a;
		} 
		if (a>0){
			if (a>d) d=a;
			else if (a<d && a<c) c=a;
		}
	}
	if (b<c && b!=0) result=d-b;
	else result=d-c;
	printf("%d\n",result);
	return 0;
}