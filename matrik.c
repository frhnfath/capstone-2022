#include <stdio.h>
int main()
{
	int x,y,a,b=0,i=0,j=0;
	scanf("%d %d",&x,&y);
	while(i<x) {
		a=0;
		if(!b)scanf("%d",&a);
		if(a==-9){
			b=1;
			a=0;
		}
		j++;
		if(j==y){
			printf("%d\n",a);
			j=0;
			i++;
		}
		else printf("%d ",a);
	}
}