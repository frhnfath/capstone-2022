#include <stdio.h>
int main() {
	int a,b,diskon,diskon1,diskon2,harga,total;
	scanf("%d",&a);
	scanf("%d",&b);
	total=b*10000;
	diskon2=0;
	if (a==1) diskon1=total*0.1;
	else if (a==2) diskon1=total*0.2;
	else if (a==3) diskon1=total*0.5;
	if (b>=10) diskon2=total*0.1;
	diskon = diskon1+diskon2;
	harga=total-diskon;
	printf("%d\n",total);
	printf("%d\n",diskon);
	printf("%d\n",harga);
}