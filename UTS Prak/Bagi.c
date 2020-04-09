#include <stdio.h>
int main() {
	unsigned int a,b,hasil,i,j,n;
	scanf("%d %d %d", &n, &a, &b);
	i=n/a;
	j=n/b;
	hasil=i+j;
	hasil=hasil-(n/(a*b));
	printf("%d\n", hasil);
	return 0;
}