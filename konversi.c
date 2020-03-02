#include <stdio.h>
int main() {
	double a,fahrenheit;
	scanf("%lf", &a);
	fahrenheit=a*9/5+32;
	printf("%.2lf\n",fahrenheit);
	return 0;
}