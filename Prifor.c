#include <stdio.h>
int main()
{
	int i;
	int N;
	printf("Baca N, print 1 s/d N\n");
	printf("N =");
	scanf ("%d", &N);

	for (i = 1; i <= N; i++)
	{
		printf("%d\n", i);
	};
	printf("Akhir Program\n");
	return 0;
}