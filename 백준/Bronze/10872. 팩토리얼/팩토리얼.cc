#include <stdio.h> 
int fac(int n) 
{ if(n > 1) 
    return n * fac(n - 1); 
 else 
     return 1; 
} 
int main(void) 
{ 
    int N; 
    scanf("%d", &N); 
    printf("%d", fac(N)); 
}

