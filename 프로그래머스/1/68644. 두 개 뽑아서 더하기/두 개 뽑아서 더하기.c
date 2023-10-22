#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
// numbers_len은 배열 numbers의 길이입니다.
int* solution(int numbers[], size_t numbers_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int len = (numbers_len - 1) * numbers_len /2;
    int* answer = (int*)malloc(sizeof(int)*len);
    int nums[len];  
    int n = 0, order = 0, cnt = 0;
    for(int i = 0; i < numbers_len; i++)
        for(int j = i + 1; j < numbers_len; j++)
            nums[n++] = numbers[i] + numbers[j];
  for(int i = 0; i < n; i++)
         for(int j = i + 1; j < n; j++)
             if(nums[i] > nums[j]){
             order = nums[i];
             nums[i] = nums[j];
             nums[j] = order;
             }
    for(int i = 0; i < n; i++)
        if(nums[i] != nums[i + 1])
            answer[cnt++] = nums[i];
    
    return answer;
}