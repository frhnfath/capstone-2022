#include <stdio.h>
int main() {
	float a,b,c,d,e,f,A,B,C,D,jumlah;
	scanf("%f",&a);
	scanf("%f",&b);
	scanf("%f",&c);
	scanf("%f",&d);
	scanf("%f %f",&e,&f);
	A=a*e;
	B=b*(e+f);
	C=c*(e+f+f);
	D=d*(e+f+f+f);
	jumlah=A+B+C+D;
	printf("%.2f",jumlah);
}