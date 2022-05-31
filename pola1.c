#include <stdio.h>
int main() {
    int n,a;
    scanf("%d",&n);
    a=1;
    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < a; ++j)
        {
            printf("*");
        }
        printf("\n");
        a+=1;
    }
    return 0;
}