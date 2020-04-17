#include <stdio.h>
int main() {
	float n,sum1;
	int a,b,c,i;
	scanf("%f",&n);
	sum1=0;
	for (i=1;i<=n;i++) {
		scanf("%d",&a);
		sum1=a+sum1;
		if (a>0) {
			if (a>b) b=a;
		}
		if (a<b && a<c) c=a;
	}
	sum1=sum1/n;
	printf("%.2f %d %d\n", sum1,c,b);
	return 0;
}