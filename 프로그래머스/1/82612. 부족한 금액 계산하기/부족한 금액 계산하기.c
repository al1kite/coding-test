#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long solution(int price, long long money, int count) {
    long long answer = -1;
    long long firstPrice = price;
    for(int i = 0; i < count; i++){
        money -= price;
        price += firstPrice;
    }
    if(money > 0)
        return 0;
    else
       return answer = -1 * money;
}