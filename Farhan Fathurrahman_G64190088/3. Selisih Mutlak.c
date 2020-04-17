#include <stdio.h>
int main() {
	int a,n;
	scanf("%d", &a);
	if (a>50) {n=a-50;
		n=n*3;
	}
	else n=50-a;
	printf("%d\n", n);
	return 0;
}