#include <stdio.h>
int main() {
	int bayar,jml,total,harga,diskon;
	scanf("%d %d",&bayar,&jml);
	total=jml*10000;
	if (bayar==1) {harga=total*0.9;
		if (jml>=10) harga=harga-(total*0.1);}
	else if  (bayar==2){ harga=total*0.8;
		if (jml>=10) harga=harga-(total*0.1);}
	else if (bayar==3) harga=total*0.5;
	diskon=total-harga;
	printf("%d\n%d\n%d\n",total,diskon,harga);
}
