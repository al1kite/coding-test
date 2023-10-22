class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
    int cnt = 0; 
    for(int i = 0; i < 10; i++){
        for(int j = 0; j < numbers.length; j++)
            if(numbers[j] != i)
                cnt++;
        if(cnt == numbers.length)
            answer += i;
        cnt = 0;
    }
        return answer;
    }
}