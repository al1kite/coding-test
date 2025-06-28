import java.util.*;

class Solution {
    public static int solution(int[] numbers, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); 

        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int index = current[0];
            int sum = current[1];

            if (index == numbers.length) {
                if (sum == target) {
                    count++;
                }
            } else {
                queue.offer(new int[]{index + 1, sum + numbers[index]});
                queue.offer(new int[]{index + 1, sum - numbers[index]});
            }
        }

        return count;
    }
}
