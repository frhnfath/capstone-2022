#include <stdio.h>
int main() {
	int a,b=1,c,d=0;
	scanf("%d",&a);
	while(b!=a){
		c=a%b;
		if (c>d) d=b;
		b++;
	}
	printf("%d\n",d);
}