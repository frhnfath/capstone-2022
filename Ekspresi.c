#include <stdio.h>
int main() {
	double a,b,hasil;
	double c,fix;
	scanf("%lf %lf", &a,&b);
	scanf("%lf", &c);
	hasil = a/b;
	fix = hasil+c;
	printf("%.2lf\n", fix);
	return 0;
}