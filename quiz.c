#include <stdio.h>
int main()
{
     float celcius, fahrenheit;
     scanf("%d", &celcius);
     fahrenheit = (9/5) * celcius + 32.0;
     printf("%.2f", fahrenheit);
     return 0;
}