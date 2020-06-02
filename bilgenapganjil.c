#include <stdio.h>
int main() {
	int a,b,c=0,d=0;
	scanf("%d",&a);
	for (int i = 1; i <= a; ++i)
	{
		scanf("%d",&b);
		if (b%2==0) c++;
		else d++;
	}
	printf("%d %d\n",c,d);
	return 0;
}