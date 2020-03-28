#include <stdio.h>
int main() {
	int a,b;
	scanf("%d", &a);
	b=a/10;
	a=b%10;
	printf("%d\n", a);
	return 0;
}