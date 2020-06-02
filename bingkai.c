#include <stdio.h>
int main()
{
    int m,n,T;
    int i,j;
    scanf("%d",&T);  // banyaknya pola
    while(T--) 
    {
        scanf("%d %d",&m,&n);  // m: baris, n: kolom
        // bingkai foto
        for(i=1;i<=3*m+1;i++) 
        {
            for(j=1;j<=3*n+1;j++) 
            {
                // kondisi bintang dan titik
                if (i%3==1) printf("*");
                else if (j%3==1) printf("*");
                else printf(".");
            }
            printf("\n");
        }
        if(T) printf("\n");
    }   
    return 0;
}