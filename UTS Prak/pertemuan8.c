#include <stdio.h>
int main() {
	int p1,p2,p3,p4;
	printf("Jawab 1 untuk benar dan 0 untuk salah\n");
	printf("Pernah pergi ke wilayah episentrum penyebaran virus?\n");
	scanf("%d",&p1);
	printf("Pernah melakukan kontak dengan orang yang berstatus PTV?\n");
	scanf("%d",&p2);
	printf("Suhu tubuh tinggi dan tenggorokan sangat sakit serta batuk sering?\n");
	scanf("%d",&p3);
	printf("Hasil uji lab adalah positif?\n");
	scanf("%d",&p4);
	printf("Hasil Pemeriksaan Anda adalah\n");
	if ((p1==1 && p3==0 && p4==0) || (p2==1 && p3==0 && p4==0)) printf("ODP\n");
	else if (((p1==1 && p3==1) || (p2==1 && p3==1)) && p4==1) printf("PTV\n");
	else if ((p1==1 && p3==1) || (p2==1 && p3==1)) printf("PDP\n");
	else if (p1==0 && p2==0 && p3==0 && p4==0) printf("OBV\n");
	else printf("Tidak Dapat Ditentukan\n");
	return 0;
}