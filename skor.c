#include <stdio.h>
int main() {
	int menang,kalah,seri,n,result=0,jumlah,i,tim1,tim=0,menang1=0,kalah1=0,seri1=0;
	scanf("%d",&n);
	for (int i = 1; i <= n; ++i)
	{
		scanf("%d %d %d",&menang,&kalah,&seri);
		jumlah=(menang*3)+(seri);
		tim++;
		menang1=menang1+menang;
		kalah1=kalah1+kalah;
		seri1=seri1+seri;
		if (jumlah>=result)
		{
			result=jumlah;
			tim1=tim;
		}
	}
	if ((menang1-kalah1)!=0 || (seri1%2)!=0st) printf("-1\n");
	else printf("%d %d\n", tim1,result);
	return 0;
}