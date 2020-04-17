#include <stdio.h>
int main() {
	float n,sum1;
	unsigned int a,b,c,d,i;
	scanf("%f",&n);
	sum1=0;
	scanf("%u",&a);
	c=a;
	d=a;
	sum1+=a;
	for (int i = 1; i < n; ++i)
	{
		scanf("%u",&b);
		sum1+=b;
		if (b>=a && b>=c) {
			c=b;
		}
		else if (b<=a && b<=d) {
			d=b;
		}
	}
	sum1/=n;
	printf("%u %u %.2f\n",d,c,sum1);
	return 0;
}