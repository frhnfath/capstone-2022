#include <stdio.h>
int main() {
	int a,besar,kecil=999999;
	a=1;
	besar=0;
	while (a!=-1) {
		scanf("%d",&a);
		if (a>=1 && a<kecil) kecil=a;
		if (a>=kecil && a>besar) besar=a;
		if (a==0 || a==-1) { 
			printf("%d %d\n",kecil,besar);
			kecil=999999;
			besar=0;
		} 
	}
	return 0;
}