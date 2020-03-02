#include <stdio.h>
int main() {
	char a;
	scanf("%c", &a);
	if (a == 'a' || a == 'A') {
		printf("4\n");
		return 0;
	}
	else if (a == 'b' || a == 'B') {
		printf("3\n");
		return 0;
	}
	else if (a == 'c' || a == 'C') {
		printf("2\n");
		return 0;
	}
	else if (a == 'd' || a == 'D') {
		printf("1\n");
		return 0;
	}
	else if (a == 'e' || a == 'E') {
		printf("0\n");
		return 0;
	}
	else {
		printf("-1\n");
		return 0;
	}
}