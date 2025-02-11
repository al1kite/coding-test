import java.util.*;

class Solution {
    public int solution(int n) {
        int sum = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            sum += c - '0'; // 문자를 정수로 변환하여 합산
        }
        return sum;
    }
}