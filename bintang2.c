#include <stdio.h>

int segitiga(){
	int x=1;
	int n;
	scanf("%d" , &n);
	for(int i = 0; i < n ; i++){	
		for(int j = n; j >= i; j--){
			printf(" ");
		}
		for(int k = 1; k <= x; k++){
			printf("*");
		}
		x=x+2;
		printf("\n");
	}
}


int main(){
	int n;
	scanf("%d" , &n);
	for(int i = 0; i < n ; i++){
		segitiga();
	}
}