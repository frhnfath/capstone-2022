#include <stdio.h>
int main() {
	int a,b,i,sum,n;
	sum=0;
	scanf("%d",&n);
	for(i=1;i<=n;i++) {
		scanf("%d %d", &a, &b);
		if ((a%b)==0 || (b%a)==0)
			sum=sum+1;
	}
	printf("%d\n", sum);
	return 0;
}