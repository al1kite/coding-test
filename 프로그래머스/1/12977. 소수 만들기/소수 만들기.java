class Solution {
    public int solution(int[] nums) {

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
  int answer = 0;
    int num = 0;
    int cnt = 0;
    for(int i = 0; i < nums.length; i++)
        for(int j = i + 1; j < nums.length; j++)
            for(int t = j + 1; t < nums.length; t++)
        {
            num = (nums[i] + nums[j] + nums[t]);
            for(int k = 2; k < num; k++){
                if(num % k == 0)
                    break;
                cnt ++;
            }
            if(cnt == num - 2)
                answer += 1;
                cnt = 0; 
        }
        return answer;
    }
}