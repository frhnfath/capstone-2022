#include <stdio.h>
int main() {
	int x;
	scanf("%d", &x);
	if (x>50000) printf("naik taksi");
	else if (x>25000) printf("naik gojek");
	else if (x>10000) printf("naik transpakuan");
	else printf("jalan kaki");
	return 0;
}