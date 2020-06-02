#include <stdio.h>
int main() {
	long int n,i,input,j,k,m=1,l=0;
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
			m+=1;
			printf("\n");
		
	}
}