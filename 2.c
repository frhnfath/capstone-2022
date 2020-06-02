#include <stdio.h>
int main() {
	float n,sum1;
	int a,b,c,d,i;
	scanf("%f",&n);
	sum1=0;
	scanf("%d",&a);
	c=a;
	d=a;
	sum1+=a;
	for (int i = 1; i < n; ++i)
	{
		scanf("%d",&b);
		sum1+=b;
		if (b>=a && b>=c) {
			c=b;
		}
		else if (b<=a && b<=d) {
			d=b;
		}
	}
	sum1/=n;
	printf("%.2f %d %d\n",sum1,d,c);
	return 0;
}