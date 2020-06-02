#include <stdio.h>
int main() {
	int min,k,s,maks,n,p,price;
	scanf("%d %d %d %d",&min,&k,&s,&maks);
	scanf("%d",&n);
	p = n-k;
	price = min + s*p;
	if (price>maks) printf("%d\n",maks);
	else printf("%d\n",price);
	return 0;
}