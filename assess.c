#include <stdio.h>
int main() {
	int a,b=2;
	for (a=0; a<=10; a++) {
		if (b>0) printf("oke\n");
		b=5-2*b;
	}
}