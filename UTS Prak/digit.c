#include <stdio.h>
int main(){
	int a;
	float b;
	scanf("%d",&a);
	a=a/10;
	a=a%10;
	b=a/3;
	printf("%.2f\n", b);
	return 0;
}