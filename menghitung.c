#include <stdio.h>
int main() {
	int i,j,a,b;
	a=0;
	b=0;
	scanf("%d",&j);
	while (i!=-99) {
		scanf("%d",&i);
		if (i<=j) {
			a=a+1;
		}
		if (i>j) {
			b=b+1;
		}
	}
	printf("%d %d\n",a,b);
	return 0;
}
