#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* s) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int cnt=0;
    for(cnt = 0; s[cnt]!='\0'; cnt++);
    char* answer = (char*)malloc(3*cnt);
    *answer = NULL;
    strcpy(answer,s);
    int temp = 0;
    int max = 0;
    for(int i=0; answer[i]!='\0'; i++){
        max = i;
        for(int j=i+1; answer[j]!='\0'; j++)
            if(answer[j] > answer[max])
                max = j;
        temp = answer[i];
        answer[i] = answer[max];
        answer[max] = temp;
    }
    return answer;
}