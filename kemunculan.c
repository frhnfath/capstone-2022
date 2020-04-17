#include <stdio.h>
int main() {
	int a,b,sum,hasil;
	hasil=0;
	scanf("%d %d",&a,&b);
	while (b!=0) {
		sum=b%10;
		if(sum==a) {
			hasil=hasil+1;
		}
		b=b/10;
	}
	if (hasil>0) printf("%d\n",hasil);
	else printf("tidak ada\n");
}