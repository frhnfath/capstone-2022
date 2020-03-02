#include <stdio.h>
int main() {
    long int a,b,c,d,e,f;
    long int A,B,A1,B1,waktu1,waktu2,waktu3,result,jam,mjam,menit,detik;
     
    scanf("%ld %ld %ld",&a,&b,&c);
    scanf("%ld %ld %ld",&d,&e,&f);
    A=a*3600;
    B=b*60;
    A1=d*3600;
    B1=e*60;
    waktu1=A+B+c;
    waktu2=A1+B1+f;
    if (waktu1>waktu2) {
        waktu3=waktu2+(24*3600);
        result=waktu3-waktu1;
        jam=result/3600;
        mjam=result%3600;
        menit=mjam/60;
        detik=mjam%60;
        printf("%ld %ld %ld\n",jam,menit,detik);
    }
    else {
        result=waktu2-waktu1;
        jam=result/3600;
        mjam=result%3600;
        menit=mjam/60;
        detik=mjam%60;
        printf("%ld %ld %ld\n",jam,menit,detik);
    }
    return 0;
}