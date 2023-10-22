#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    int i, j;
    int decimal = 1;
    int numeral[100000000];
    for(i = 0; n >= 3; i++){
        numeral[i] = n % 3;
        n /= 3;
        decimal *= 3;
    } numeral[i] = n;
    for(j = 0; j <= i; j++){
        answer += numeral[j] * decimal;
        decimal /= 3;
        }
    return answer;
}