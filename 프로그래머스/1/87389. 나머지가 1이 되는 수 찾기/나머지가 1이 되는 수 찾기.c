#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    int ans[n];
    int j = 0, min = n;
    for(int i = 1; i < n; i++)
        if(n % i == 1)
            ans[j++] = i;
    for(int i = 0; i < j; i++)
        if(ans[i] < min)
            min = ans[i];
    answer = min; 
    return answer;
}