#include <stdio.h>
int main() {
	long int payment,total, sum, price,discount,discount1,discount2;
	scanf("%ld %ld",&payment,&sum);
	total=sum*10000;

	if (payment==1) {
		discount1=total*0.1;
		 if (sum>=10) {discount2=total*0.1;
			discount=discount1+discount2;
			price=total-discount;}
	}
	else if (payment==2) {
		discount1=total*0.2;
		 if (sum>=10) {discount2=total*0.1;
			discount=discount1+discount2;
			price=total-discount;}
	}
	else if (payment==3) {discount=total*0.5;
		price=total-discount;}

	printf("%ld\n%ld\n%ld\n",total,discount,price);

	return 0;

}