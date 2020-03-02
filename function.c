#include <stdio.h>
#include <math.h>
int main() {
	int a,b,c;
	float d,e,f;
	scanf("%d %d %d", &a,&b,&c);
	d=sqrt(b*b-4*a*c);
	e=(-b+d)/(2*a);
	f=(-b-d)/(2*a);
	printf("%.2f %.2f\n", e,f);
	return 0;
}