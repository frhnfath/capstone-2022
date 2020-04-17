#include <stdio.h>
int main() {
	int c=0,n,a,b,sum=0;
	scanf("%d",&n);
	while (c<n) {
		scanf("%d %d", &a, &b);
		sum += a*b;
	}
	printf("%d\n", sum);
	return 0;
}