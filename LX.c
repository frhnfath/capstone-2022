#include <stdio.h>
int main(){
	int a;
	long int b;
	double c;
	scanf("%d %d", &a,&b);
	scanf("%lf", &c);
	printf("%d %.2lf %ld\n", a,c,b );
	return 0;
}