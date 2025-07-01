import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 열 (가로)
        int m = sc.nextInt(); // 행 (세로)

        int[][] box = new int[m][n];
        int[][] visited = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();
        boolean allRipe = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                box[i][j] = val;
                if (val == 0) allRipe = false;
                if (val == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        if (allRipe) {
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (box[nx][ny] == -1 || visited[nx][ny] > 0) continue;

                visited[nx][ny] = visited[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j] == 0 && visited[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, visited[i][j]);
            }
        }

        System.out.println(max - 1); 
    }
}
