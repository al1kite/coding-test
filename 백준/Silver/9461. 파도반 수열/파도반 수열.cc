#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h> 
unsigned long long padovan(int n);
unsigned long long p[101] = { 1,1,1,1 };
int main(void)
{
    int cnt = 0;
    int* mal;
    scanf("%d", &cnt);
    mal = (int*)malloc(sizeof(int) * cnt); 

    for (int i = 0; i < cnt; i++) {
        scanf("%d", &mal[i]);
        printf("%lld\n", padovan(mal[i]));
    }

    free(mal); 
    return 0;
}
unsigned long long padovan(int n)
{
    if (p[n] != 0)
        return p[n];
    else
        return p[n] = padovan(n - 2) + padovan(n - 3);
}