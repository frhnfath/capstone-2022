#include <stdio.h>
int main(){
	float a,b,c,d,e,f,g,harga,A,B,C,pajak,net;
	scanf("%f %f", &a,&b);
	scanf("%f %f", &c,&d);
	scanf("%f %f", &e,&f);
	scanf("%f", &g);
	A=a*b;
	B=c*d;
	C=e*f;
	harga=A+B+C;
	pajak=g/100*harga;
	net=harga-pajak;
	printf("%.2f %.2f\n", pajak,net);
	return 0;
}