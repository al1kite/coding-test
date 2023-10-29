import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] num = s.split(" ");
        Integer[] number = new Integer[num.length]; 
        for(int i=0; i < num.length; i++){
            number[i] = Integer.parseInt(num[i]);
        }
        Arrays.sort(number);
        answer += number[0];
        answer += " ";
        answer +=  number[number.length - 1];
        
        return answer;
    }
}