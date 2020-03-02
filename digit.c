#include <stdio.h>
int main() {
	long int jumlah;
	long int i,n,hasil;
	scanf("%d",&n);
	jumlah=0;
	i=n;
	while (i!=0) {
		hasil=i%10;
		jumlah=jumlah+hasil;
		i=i/10;
	}
    printf("%ld\n",jumlah);
    return 0;
}