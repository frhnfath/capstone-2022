#include <stdio.h>

int main() {
	long int n,i,input,j,k,m=1,l=0;
	scanf("%ld",&n);
	for (i=0;i<n;i++) {
		scanf("%ld",&input);
		for (j=1;j<=input;j++) {
			for (k=j;k<=input-1;k++) {
				printf(" ");
			}
			while (l<m) {
				printf("*");
				l++;
			}
			l=0;
			m+=2;
			printf("\n");
		}
		m=1;
		if(i!=n-1) {
			printf("\n");
		}
	}
	return 0;
}