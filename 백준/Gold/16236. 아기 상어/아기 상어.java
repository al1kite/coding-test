
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1}; 
    static int[] dy = {0, -1, 1, 0};

    static class Shark {
        int x, y, size, eat;
        Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = 2;
            this.eat = 0;
        }
    }

    static class Fish implements Comparable<Fish> {
        int x, y, dist;

        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist == o.dist) {
                if (this.x == o.x) 
                    return this.y - o.y; // 왼쪽 우선
                return this.x - o.x; // 위쪽 우선
            }
            return this.dist - o.dist;
        }
    }

    static Shark shark;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }

        int time = 0;
        while (true) {
            Fish fish = bfs(); // 가장 가까운 먹을 수 있는 물고기 탐색
            if (fish == null) break; // 없으면 종료

            // 이동
            shark.x = fish.x;
            shark.y = fish.y;
            time += fish.dist;
            shark.eat++;
            map[fish.x][fish.y] = 0;

            if (shark.eat == shark.size) {
                shark.size++;
                shark.eat = 0;
            }
        }

        System.out.println(time);
    }

    // BFS로 가장 우선순위 높은 먹을 수 있는 물고기 탐색
    static Fish bfs() {
        visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Fish> fishes = new PriorityQueue<>();

        q.offer(new int[]{shark.x, shark.y, 0});
        visited[shark.x][shark.y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    int value = map[nx][ny];
                    if (value <= shark.size) { // 이동 가능
                        visited[nx][ny] = true;
                        if (value != 0 && value < shark.size) { // 먹기 가능
                            fishes.offer(new Fish(nx, ny, dist + 1));
                        }
                        q.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }

        return fishes.isEmpty() ? null : fishes.poll(); // 가장 우선순위 높은 물고기
    }
}
