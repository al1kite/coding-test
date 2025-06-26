import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int i) {
        Stack<Integer> stack = new Stack<>();
        stack.push(i);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                for (int next : graph.get(node)) {
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }
    }

}
