#include <stdio.h>
int main() {
	int i,n;
	double a,sum1,sum2,jumlah,rerata;
	sum1=0;
	sum2=0;
	jumlah=0;
	scanf("%d",&n);
	for (i=1;i<=n;i++) {
		scanf("%lf",&a);
		if (a>0) {
			if (a>sum1)
				sum1=a;
		}
		if (a<0) {
			if (a<sum2)
				sum2=a;
		}
		jumlah=jumlah+a;
	}
	rerata=jumlah/n;
	printf("%.2lf %.2lf %.2lf\n", sum2, sum1, rerata);
	return 0;
}