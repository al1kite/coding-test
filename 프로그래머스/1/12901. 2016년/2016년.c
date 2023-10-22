#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

char* solution(int a, int b) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    char* answer = (char*)malloc(3);
    *answer = NULL;
    
    int day = b;
    int days[12] = {31,29,31,30,31,30,31,31,30,31,30,31};
    char* week[7] = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
    for(int i = 0; i < a -1; i++)
        day += days[i];
    strcat(answer,week[day%7]);
    return answer;
}