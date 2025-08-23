import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.offer(s);
        
        if (!pq.isEmpty() && pq.peek() >= K) return 0;
        
          while (!pq.isEmpty()) {
            int top = pq.poll(); 
            if (top >= K) return answer; 

            if (pq.isEmpty()) { 
                return -1;
            }
              
            int second = pq.poll();  
            long mixed = (long)top + 2L * second; 
            pq.offer((int)mixed);
            answer++;
        }
        return -1;

    }
}