#include <stdio.h>
int main() {
	int a,n=1,sum=0;
	while(a!=-99) {
		scanf("%d",&a);
		if (a==-99) break;
		if (a==-1) {n++; a++;}
		sum+=a;
	}
	if (sum==0) printf("0 0\n");
	else printf("%d %d\n",n,sum);
	return 0;
}