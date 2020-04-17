#include <stdio.h>
int main() {
	int a,i,b;
	b=0;
	scanf("%d",&a);
	while(a!=0){
		a=a/10;
		b=b+1;
	}
	printf("%d\n",b);
	return 0;
}