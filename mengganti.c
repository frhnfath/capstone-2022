#include <stdio.h>
int main() {
	unsigned long int a,b,c,i=0;
	scanf("%lu %lu",&a,&b);
	while(c!=-1){
        scanf("%lu",&c);
        if (c==-1) break;
        if (i>0) printf(" ");
		if (c==a) printf("%lu",b);
		else printf("%lu",c);
		i++;
	}
	printf("\n");
	return 0;
}
