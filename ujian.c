#include <stdio.h>
int main() {
	float a,b,c,X;
	scanf("%f %f %f", &a,&b,&c);
	X=(a+b+c)/3;
	if (X < 30) {
		printf("%.2fKURANG", X);
	}
	else if (X < 60 && X >= 30) {
		printf("%.2fCUKUP", X);
	}
	else if (X >= 60) {
		printf("%.2fBAIK", X);
	}
	return 0;
}