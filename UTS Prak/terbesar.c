#include <stdio.h>
int main(){
	int a,b,c;
	scanf("%d %d %d", &a, &b, &c);
	if (a>b && a>c) printf("1\n");
	else if (b>a && b>c) printf("2\n");
	else if (c>a && c>a) printf("3\n");
	else if (a>c && a==b) printf("12\n");
	else if (a>b && a==c) printf("13\n");
	else if (b>a && b==c) printf("23\n");
	else if (a==b && a==c) printf("123\n");
	return 0;	
}