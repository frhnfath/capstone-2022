#include <stdio.h>
int main() {
	int jam1,menit1,detik1,jam2,menit2,detik2,waktu,waktu1,waktu2;
	scanf("%d %d %d", &jam1, &menit1, &detik1);
	scanf("%d %d %d", &jam2, &menit2, &detik2);
	jam1=jam1*3600;
	menit1=menit1*60;
	jam2=jam2*3600;
	menit2=menit2*60;
	waktu1=jam1+menit1+detik1;
	waktu2=jam2+menit2+detik2;
	if (waktu1>waktu2) {
		waktu2=waktu2+(24*3600);
	}
	waktu=waktu2-waktu1;
	jam1=waktu/3600;
	waktu=waktu%3600;
	menit1=waktu/60;
	detik1=waktu%60;
	printf("%d %d %d\n", jam1, menit1, detik1);
	return 0;
}