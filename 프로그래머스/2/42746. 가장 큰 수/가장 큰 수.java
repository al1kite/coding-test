import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. int → String 변환
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 2. 정렬: (b+a) vs (a+b)
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 3. 예외 처리: 모두 0인 경우
        if (arr[0].equals("0")) {
            return "0";
        }

        // 4. 이어 붙이기
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}