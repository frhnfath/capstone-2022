#include <stdio.h>
int main() {
	int a,b,c,d,e,f,jam1,menit1,jam2,menit2,waktu1,waktu2,result;
	scanf("%d %d %d",&a,&b,&c);
	scanf("%d %d %d",&d,&e,&f);
	jam1=a*3600;
	menit1=b*60;
	waktu1=jam1+menit1+c;
	jam2=d*3600;
	menit2=e*60;
	waktu2=jam2+menit2+f;
	if (waktu1 > waktu2) {
		printf("wrong input");
	}
	else {
		result=waktu2-waktu1;
		printf("%d", result);
	}
	return 0;
}