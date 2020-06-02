#include <stdio.h>
void test() {
	int a=1,b,c=0,n=5;
	for (;c+=n--, b=n--;) printf("%d%d",a,b);	
}

int main() {
	test();
	return 0;
}