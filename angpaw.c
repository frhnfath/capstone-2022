#include <stdio.h>

long money;

int main()
{
	scanf("%ld",&money);
	if(money/200 != 0) printf("200 %ld\n", money/200);
	money%=200;
	if(money/100 != 0) printf("100 %ld\n", money/100);
	money%=100;
	if(money/50 != 0) printf("50 %ld\n", money/50);
	money%=50;
	if(money/20 != 0) printf("20 %ld\n", money/20);
	money%=20;
	if(money/10 != 0) printf("10 %ld\n", money/10);
	money%=10;
	if(money/5 != 0) printf("5 %ld\n", money/5);
	money%=5;
	if(money/2 != 0) printf("2 %ld\n", money/2);
	money%=2;
	if(money != 0) printf("1 %ld\n", money);
}
