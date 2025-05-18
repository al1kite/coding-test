import java.util.*;

class Solution {
    public int solution(int n, int[][] vertex) {

        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : vertex) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        int max = 0;
        for (int dist : distance) {
            if (dist > max) {
                max = dist;
            }
        }

        int count = 0;
        for (int dist : distance) {
            if (dist == max) {
                count++;
            }
        }

        return count;
    }
}
