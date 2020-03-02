#include <stdio.h>
int main() {
    unsigned int a,b,hasil,i,j,n,result;
    scanf("%d %d %d",&n,&a,&b);
    i=n/a;
    j=n/b;
    hasil=i+j;
    result=hasil-(n/(a*b));
    printf("%d\n",result);
    return 0;
}