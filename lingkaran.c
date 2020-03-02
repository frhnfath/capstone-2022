#include <stdio.h>

int main(){
	double diameter;
	double keliling,luas;
	double phi = 3.14;
	scanf("%lf", &diameter);
	keliling=2*phi*diameter/2;
	luas=phi*diameter/2*diameter/2;
	printf("%.2lf %.2lf\n",keliling, luas);
	return 0;
}