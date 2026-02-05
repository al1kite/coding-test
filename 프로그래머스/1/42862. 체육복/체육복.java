class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n+1];
        
        for(int l : lost) {
            students[l] = -1;
        }
        for(int r : reserve) {
            students[r] += 1;
        }
        
        for(int i=1; i<=n; i++) {
            if(students[i] == -1){
                if(students[i-1] == 1){
                    answer++;
                    students[i-1] -= 1;
                    students[i] += 1;
                } else if(i != n && students[i+1] == 1){
                    answer++;
                    students[i+1] -= 1;
                    students[i] += 1;
                }
            } else {
                answer++;
            }
        }
        return answer;
    }
}