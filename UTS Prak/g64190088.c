#include <stdio.h>
int main() {
	int p1,p2,p3,p4;
	scanf("%d %d %d %d",&p1,&p2,&p3,&p4);
	if ((p1==1 && p3==0 && p4==0) || (p2==1 && p3==0 && p4==0)) printf("ODP\n");
	else if (((p1==1 && p3==1) || (p2==1 && p3==1)) && p4==1) printf("PTV\n");
	else if ((p1==1 && p3==1) || (p2==1 && p3==1)) printf("PDP\n");
	else if (p1==0 && p2==0 && p3==0 && p4==0) printf("OBV\n");
	else printf("Tidak Dapat Ditentukan\n");
	return 0;
}