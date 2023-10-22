#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* s) {
    int answer = 0;
    int position = 1;
    for(int i = 0; s[i] != '\0'; i++)
        position *= 10;
    if(s[0] == '-'){
        position /= 10;
        for(int i = 1; s[i] != '\0'; i++){
        position /= 10;
        answer -= (s[i] - 48) * position;
        }
    }
    else if(s[0] == '+'){
        position /= 10;
        for(int i = 1; s[i] != '\0'; i++){
        position /= 10;
        answer += (s[i] - 48) * position;
        }
    }
    else 
        for(int i = 0; s[i] != '\0'; i++){
            position /= 10;
            answer += (s[i] - 48) * position;
        }
    
    return answer;
}