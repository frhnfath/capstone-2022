#include <stdio.h>
int main() {
	int a,b=1;
	scanf("%d",&a);
	for (int i = 0; i < a; ++i)
	{
		if (i%2==0) {
			printf("%d",b);
			b--;
		}
		else {
			printf("%d\n",b);
			b++;
		}
		if ((b-1)%4==0){
		printf("\n"); 
		b=b*2;
		}
	}
	return 0;
}