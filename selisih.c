#include <stdio.h>
int main() {
	int a,b,c,d,A,B,C,D,E,F; 

	scanf("%d %d %d %d", &a,&b,&c,&d);
	A = a-b;
	B = b-c;
	C = c-d;
	D = b-a;
	E = c-b;
	F = d-c;

	if (A>B && A>C && A>D && A>E && A>F) {
		printf("%d\n", A);
	}
	else if (B>A && B>C && B>D && B>E && B>F) {
		printf("%d\n", B);
	}
	else if (C>B && C>A && C>D && C>E && C>F) {
		printf("%d\n", C);
	}
	else if (D>B && D>A && D>C && D>E && D>F) {
		printf("%d\n", D);
	}
	else if (E>B && E>A && E>D && E>C && E>F) {
		printf("%d\n", E);
	}
	else if (F>B && F>A && F>D && F>E && F>C) {
		printf("%d\n", F);
	}
	return 0;
}