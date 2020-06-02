#include <stdio.h>
int main() {
	int i=0;
	float a,b,c=0;
	scanf("%f",&a);
	while(i<a) {
		scanf("%f",&b);
		c=c+b;
		i++;
	}
	b=c/a;
	printf("%.3f",b);
	return 0;
}