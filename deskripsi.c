#include <stdio.h>
int main() {
	int i,n,sum1,sum2;
	double a,jumlah,rerata;
	sum1=0;
	sum2=999999;
	jumlah=0;
	scanf("%d",&n);
	for (i=1;i<=n;i++) {
		scanf("%lf",&a);
		if (a>0) {
			if (a>sum1)
				sum1=a;
		}
		if (a<99999) {
			if (a<sum2)
				sum2=a;
		}
		jumlah=jumlah+a;
	}
	rerata=jumlah/n;
	printf("%d %d %.2lf\n", sum2, sum1, rerata);
	return 0;
}
