#include <stdio.h>
int main() {
	int a,b,sum,i,result;
	result=0;
	scanf("%d",&a);
	for (i=2;i<a;i++) {
		sum=a%i;
		if (sum==0) result=result+1; 
	}
	printf("%d\n", result);
	return 0;
}