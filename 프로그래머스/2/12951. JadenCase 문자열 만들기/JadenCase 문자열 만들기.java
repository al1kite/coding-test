class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = new char[s.length()];
 
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        } 
        if(arr[0] >= 'a' && arr[0] <= 'z')
            answer += (char)(arr[0] - 32);
        else
            answer += arr[0];
        
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] == ' '){
                if(arr[i] >= 'a' && arr[i] <= 'z')
                    answer += (char)(arr[i] - 32);
                else answer += arr[i];
            } else {
                if(arr[i] >= 'A' && arr[i] <= 'Z')
                    answer += (char)(arr[i] + 32);
                else
                   answer += arr[i];
            }
        }
        return answer;
    }
}