#include <math.h>
#include <stdio.h>
int main() {
	int a,b,c,d,x,y,x1,x2;
	scanf ("%d %d",&a,&b);
	scanf ("%d %d",&c,&d);
	scanf ("%d %d",&x,&y);
	x1=sqrt((a-x)*(a-x)+(b-y)*(b-y));
	x2=sqrt((c-x)*(c-x)+(d-y)*(d-y));
	if (x1>x2) {
		printf("2\n");
	}
	else if (x1==x2) {
		printf("12\n");
	}
	else printf("1\n");
	return 0;
}