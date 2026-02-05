import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            // 지금 자리(c)가 더 크면, 앞에서 작은 숫자들을 제거해서 크게 만든다
            while (k > 0 && !stack.isEmpty() && stack.peekLast() < c) {
                stack.pollLast();
                k--;
            }
            stack.addLast(c);
        }

        // 아직 k가 남았다면 뒤에서 제거 (내림차순 같은 경우)
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        // 스택 앞에서부터 정답 만들기
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pollFirst());

        return sb.toString();
    }
}
