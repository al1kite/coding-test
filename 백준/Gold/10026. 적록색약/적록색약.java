import java.util.*;

public class Main {
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine(); 

        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        // 일반인 시야
        visited = new boolean[n][n];
        int normalCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, false);
                    normalCount++;
                }
            }
        }

        // 적록색약 시야
        visited = new boolean[n][n];
        int colorWeaknessCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, true);
                    colorWeaknessCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorWeaknessCount);
    }

    public static void bfs(int x, int y, boolean isColorWeakness) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        char startColor = map[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny]) {
                        if (checkColor(startColor, map[nx][ny], isColorWeakness)) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }

    public static boolean checkColor(char c1, char c2, boolean isColorWeakness) {
        if (isColorWeakness) {
            if ((c1 == 'R' || c1 == 'G') && (c2 == 'R' || c2 == 'G')) {
                return true;
            }
            return c1 == c2;
        } else {
            return c1 == c2;
        }
    }
}
