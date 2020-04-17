#include <stdio.h>
int main() {
	int a,b,c;
	scanf("%d %d",&a,&b);
	while(c!=-1){
        scanf("%d",&c);
		if (c==a) printf("%d ",b);
		else if (c==b) printf("%d ",a);
		else printf("%d ",c);
	}
	printf("\n");
	return 0;
}
