import java.util.*;

public class Main {
    static final int MAX = 100001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int k = sc.nextInt(); 

        int[] time = new int[MAX]; 
        boolean[] visited = new boolean[MAX];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == k) {
                System.out.println(time[current]); 
                break;
            }

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next >= 0 && next < MAX && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    time[next] = time[current] + 1;
                }
            }
        }
    }
}

