#include <stdio.h>
  
int main()
{
    long int payment, jumlah, total1, total2, total3, total4, a;
  
    scanf("%ld %ld", &payment,&jumlah);
    total1 = jumlah*10000;
  
    if (payment == 1 && total1 <100000)
    {
        total2 = total1*0.1;
        total4 = total1-total2;
        a = total2;
    }
    else if (payment == 1 && total1 >= 100000)
    {
        total2 = total1*0.1;
        total3 = total1*0.1;
        total4 = total1-total2-total3;
        a = total2 + total3;
    }
    else if (payment == 2 && total1 < 100000)
    {
        total2 = total1*0.2;
        total4 = total1-total2;
        a = total2;
    }
    else if (payment == 2 && total1 >=100000)
    {
        total2 = total1*0.2;
        total3 = total1*0.1;
        total4 = total1-total2-total3;
        a = total2 + total3;
    }
    else if (payment == 3)
    {
        total2 = total1*0.5;
        total4 = total1-total2;
        a = total2;
    }
    printf("%ld\n%ld\n%ld\n",total1,a,total4);
  
    return 0;
}