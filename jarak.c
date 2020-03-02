#include <stdio.h>
#include <math.h>
int main() {
	int a,b,c,d,x,y,x1,x2,x3,jarak1,jarak2;
	
	scanf ("%d %d",&a,&b);
	scanf ("%d %d",&c,&d);
	scanf ("%d %d",&x,&y);
	
	x1=sqrt(a*a+b*b);
	x2=sqrt(c*c+d*d);
	x3=sqrt(x*x+y*y);
	
	jarak1=x3-x1;
	jarak2=x3-x2;
	
	if (jarak1>jarak2) {
		printf("2\n");
	}
	else if (jarak1==jarak2) {
		printf("12\n");
	}
	else printf("1\n");
	return 0;
}