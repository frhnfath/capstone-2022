#include <stdio.h>
   int main()
   {
      int i, j,a,b,n=0;
      scanf("%d %d",&a,&b);
      for (i=1; i<=a; i++) {
         for (j=1; j<=b; j++) {
            printf("%d ",n);
            n++;
            if (n>=9) n=0;
         }
         printf("\n");
      }
      return 0;
   }