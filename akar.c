#include <stdio.h>
int main() {
	double a,b,c,result;
	scanf("%lf %lf %lf",&a,&b,&c);
	result=(b*b)-(4*a*c);
	if (result > 0) {
		printf("2\n");
	}
	else if (result == 0) {
		printf("1\n");
	}
	else printf("0\n");
}