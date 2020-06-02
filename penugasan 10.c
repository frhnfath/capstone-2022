#include <stdio.h>
int main() {
	int a,b=0,n=1,sum=0,c=0;
	while(a!=-99) {
		scanf("%d",&a);
		if (a==-1) {sum+=b; n++; }
		else b+=a;
		c=a;
	}
	if (b==0) printf("0 0\n");
	if (n==1) printf("%d %d\n",n,b);
	else printf("%d %d\n",n,sum+c);
	return 0;
}