#include <stdio.h>
#include <math.h>
int main() {
	double a,b;
	int c;
	scanf("%lf",&a);
	b=a-floor(a);
	c=a-b;
	printf("%d %.5lf\n",c,b);
	return 0;
}