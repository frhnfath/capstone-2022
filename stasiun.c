#include <stdio.h>
int main(){
	int Min,K,S,Maks;
	int N,Tarif;
	scanf("%d %d %d %d",&Min,&K,&S,&Maks);
	scanf("%d",&N);
	if (K<=N) Tarif=Min+(N-K)*S;
	else Tarif=Min;
	if (Tarif>Maks) Tarif=Maks;
	printf("%d\n", Tarif);
	return 0;
}