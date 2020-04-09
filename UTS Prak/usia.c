#include <stdio.h>
int main() {
	int bulan,tahun;
	scanf("%d", &bulan);
	tahun=bulan/12;
	bulan=bulan%12;
	printf("%d %d\n", tahun, bulan);
	return 0;
}