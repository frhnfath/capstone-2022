#include <stdio.h>
int main() {
	double celcius,fahrenheit;
	scanf("%lf", &celcius);
	fahrenheit=celcius*9/5+32;
	printf("%.2lf\n", fahrenheit);
	return 0;
}