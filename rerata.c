/* Program LOOP03 */
   #include <stdio.h>
   int main()
   {
      float bil, jumlah;
      int i,n;
      jumlah=0;                   
      scanf("%d", &n);            
      for (i=1; i<=n; i++) {      
         scanf("%f", &bil);       
         jumlah=jumlah+bil;
      }
      jumlah=jumlah/n;
      printf("%.3f\n", jumlah);     
      return 0;
   }