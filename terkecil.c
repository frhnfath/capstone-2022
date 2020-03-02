#include <stdio.h>
int main() {
	int a,b,i,sum1;

	scanf("%d",&a);
	sum1=a;
	if (a==-99) printf("empty\n");

	else {
		
	for (;b!=-99;i++) {
		scanf("%d",&b);
		if (sum1>b && b!=-99) sum1=b;
		else if (sum1<b && b!=-99) sum1=sum1;
		
		}
	printf("%d\n", sum1);
	}
}