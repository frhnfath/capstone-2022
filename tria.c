#include <stdio.h>
int main () {
	int nilai,i;
	int max=-9999, min=9999, sum=0;
	float a,n;
	scanf ("%f", &n);
	for (i=1; i<=n; i++) {
		scanf ("%d", &nilai);
		if (nilai>max) max = nilai;
		else if(nilai<min) min = nilai;
		if (min==9999 || nilai<min) min=nilai;
		sum+=nilai;
	}
	a=sum/n;
	printf ("%.2f %d %d\n", a, min, max);
	return 0;
}
