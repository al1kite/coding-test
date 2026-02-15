import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int min = 10000;
        Arrays.sort(citations); // 0 1 3 5 6
        
        for(int i=0; i<citations.length - 1; i++){
            min = Math.min(citations[i], citations.length - i);
            answer = Math.max(min, answer);
            
        }
        return answer;
    }
}