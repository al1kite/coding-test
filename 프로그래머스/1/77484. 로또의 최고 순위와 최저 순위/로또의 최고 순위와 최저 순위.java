class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int max = 0; 
        int min = 0;
        for(int i = 0; i < lottos.length; i++)
            for(int j = 0; j < win_nums.length; j++)
                if(lottos[i] == win_nums[j]){
                    max++; 
                    min++;
                }
                else if (lottos[i] == 0){
                    max++;
                    break;
                }
        if(max < 2)
            answer[0] = 6;
        else
            answer[0] = 7 - max;
        if(min < 2)
            answer[1] = 6;
        else
            answer[1] = 7 - min;
        return answer;
    }
}