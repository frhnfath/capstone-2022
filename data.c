#include <stdio.h>
#include <limits.h>
int main() {
	long int n,i,max,min,value;
	double rerata,sum;
	max=INT_MIN;
	min=INT_MAX;
	sum=0.00;

	scanf("%d",&n);
	for (int i = 0; i < n; ++i)
	{
		scanf("%d",&value);
		sum += value;
		if (min>value) min=value;
		if (max<value) max=value;
	}
	rerata=sum/n;
	printf("%d %d %.2f\n",min,max,rerata);
	return 0;
}