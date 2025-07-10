import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 컴퓨터 수 (1< n < 100)
        int m = sc.nextInt(); // 연결 수

        int[][] network = new int[n + 1][n + 1]; // 인접 행렬
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            network[a][b] = 1;
            network[b][a] = 1; // 양방향
        }

        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (network[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
