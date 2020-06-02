#include <stdio.h>
int main() {
	int sum=0,n,nilai;
	scanf("%d",&n);
	while (n--) {
		scanf("%d", &nilai);
		if (nilai) break;
		sum+=nilai;
	}
	printf("%d\n", sum);
	return 0;
}