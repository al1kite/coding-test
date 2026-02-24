import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int[] people, int limit) {
        Arrays.sort(people);   
        recursion(people, limit, 0, people.length - 1);
        return answer;
    }
    public void recursion(int[] people, int limit, int left, int right){
        if (left > right) return;
        answer++;
        
        if(people[left] + people[right] <= limit){
            recursion(people, limit, left + 1, right - 1);
        } else {
            recursion(people, limit, left, right - 1);
        }
    }
}